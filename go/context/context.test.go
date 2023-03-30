package gocontext

import (
	"context"
	"fmt"
	"math/rand"
	"runtime"
	"sync"
	"sync/atomic"
	"time"
)

type otherContext struct {
	context.Context
}

func TestWithCancel() {

	c1, cancel := context.WithCancel(context.Background())

	o := otherContext{c1}

	c2, _ := context.WithCancel(o)

	contexts := []context.Context{c1, o, c2}

	cancel()

	for i, c := range contexts {
		select {
		case <-c.Done():
			fmt.Printf(" done with %s\n", c)
		default:
			fmt.Printf("<-c[%d].Done() blocked, but shouldn't have\n", i)
		}
	}

	time.Sleep(3 * time.Second)
}

func TestParentFinishChild() {
	parent, cancel := context.WithCancel(context.Background())

	cancelChild, stop := context.WithCancel(parent)
	defer stop()

	valueChild := context.WithValue(parent, "key", "value")
	timerChild, stop := context.WithTimeout(valueChild, 1000*time.Hour)
	defer stop()

	select {
	case x := <-parent.Done():
		fmt.Errorf("<-parent.Done() == %v want nothing (it should block)", x)
	case x := <-cancelChild.Done():
		fmt.Errorf("<-cancelChild.Done() == %v want nothing (it should block)", x)
	case x := <-timerChild.Done():
		fmt.Errorf("<-timerChild.Done() == %v want nothing (it should block)", x)
	case x := <-valueChild.Done():
		fmt.Errorf("<-valueChild.Done() == %v want nothing (it should block)", x)
	default:
	}

	cancel()

	fmt.Println(">>>>>>>>>> parent children: ", parent)

	check := func(ctx context.Context, name string) {
		select {
		case <-ctx.Done():
		default:
			fmt.Errorf("<-%s.Done() blocked, but shouldn't have", name)
		}
		if e := ctx.Err(); e != context.Canceled {
			fmt.Println("%s.Err() == %v want %v", name, e, context.Canceled)
		}
	}
	check(parent, "parent")
	check(cancelChild, "cancelChild")
	check(valueChild, "valueChild")
	check(timerChild, "timerChild")

	precanceledChild := context.WithValue(parent, "key", "value")
	select {
	case <-precanceledChild.Done():
	default:
		fmt.Errorf("<-precanceledChild.Done() blocked, but shouldn't have")
	}
	if e := precanceledChild.Err(); e != context.Canceled {
		fmt.Errorf("precanceledChild.Err() == %v want %v", e, context.Canceled)
	}

}

func TestChildFinishesFirst() {
	cancelable, stop := context.WithCancel(context.Background())
	defer stop()

	for _, parent := range []context.Context{context.Background(), cancelable} {
		child, cancel := context.WithCancel(parent)
		select {
		case x := <-parent.Done():
			fmt.Errorf("<-parent.Done() == %v want nothing (it should block)", x)
		case x := <-child.Done():
			fmt.Errorf("<-child.Done() == %v want nothing (it should block)", x)
		default:
		}

		cancel()

		select {
		case <-child.Done():
		default:
			fmt.Errorf("<-child.Done() blocked, but shouldn't have")
		}

		select {
		case x := <-parent.Done():
			fmt.Errorf("<-parent.Done() == %v want nothing (it should block)", x)
		default:
		}
		if e := parent.Err(); e != nil {
			fmt.Errorf("parent.Err() == %v want nil", e)
		}
	}

}

func quiescent() time.Duration {
	return 5 * time.Second
}
func testDeadline(c context.Context, name string) {
	d := quiescent()
	timer := time.NewTimer(d)
	defer timer.Stop()
	select {
	case <-timer.C:
		fmt.Errorf("%s: context not timed out after %v", name, d)
	case <-c.Done():
		fmt.Printf(" %s context alread closed\n", c)
	}
	if e := c.Err(); e != context.DeadlineExceeded {
		fmt.Errorf("%s: c.Err() == %v; want %v", name, e, context.DeadlineExceeded)
	}
}

const (
	shortDuration    = 1 * time.Millisecond // a reasonable duration to block in a test
	veryLongDuration = 1000 * time.Hour     // an arbitrary upper bound on the test's running time
)

func TestDeadline() {
	c, _ := context.WithDeadline(context.Background(), time.Now().Add(shortDuration))
	fmt.Printf(">>>>>>>>>>>>> %s\n", c)
	testDeadline(c, "WithDeadline")
	c, _ = context.WithDeadline(context.Background(), time.Now().Add(shortDuration))
	o := otherContext{c}
	testDeadline(o, "WithDeadline+otherContext")

	c, _ = context.WithDeadline(context.Background(), time.Now().Add(shortDuration))
	o = otherContext{c}
	c, _ = context.WithDeadline(o, time.Now().Add(veryLongDuration))
	testDeadline(c, "WithDeadline+otherContext+WithDeadline")

	c, _ = context.WithDeadline(context.Background(), time.Now().Add(-shortDuration))
	testDeadline(c, "WithDeadline+inthepast")

	c, _ = context.WithDeadline(context.Background(), time.Now())
	testDeadline(c, "WithDeadline+now")
}

func TestTimeout() {
	c, _ := context.WithTimeout(context.Background(), shortDuration)
	testDeadline(c, "WithTimeout")
	c, _ = context.WithTimeout(context.Background(), shortDuration)
	o := otherContext{c}
	testDeadline(o, "WithTimeout+otherContext")

	c, _ = context.WithTimeout(context.Background(), shortDuration)
	o = otherContext{c}
	c, _ = context.WithTimeout(o, veryLongDuration)
	testDeadline(c, "WithTimeout+otherContext+WithTimeout")
}

func TestCanceledTimeout() {
	c, _ := context.WithTimeout(context.Background(), time.Second)
	o := otherContext{c}
	c, cancel := context.WithTimeout(o, veryLongDuration)
	cancel()
	select {
	case <-c.Done():
	default:
		fmt.Errorf("<-c.Done() blocked, but shouldn't have")
	}
	if e := c.Err(); e != context.Canceled {
		fmt.Errorf("c.Err() == %v want %v", e, context.Canceled)
	}
}

type key1 int
type key2 int

var k1 = key1(1)
var k2 = key2(1)
var k3 = key2(3)

func TestValues() {
	check := func(c context.Context, nm, v1, v2, v3 string) {
		if v, ok := c.Value(k1).(string); ok == (len(v1) == 0) || v != v1 {
			fmt.Errorf(`%s.Value(k1).(string) = %q, %t want %q, %t`, nm, v, ok, v1, len(v1) != 0)
		}
		if v, ok := c.Value(k2).(string); ok == (len(v2) == 0) || v != v2 {
			fmt.Errorf(`%s.Value(k2).(string) = %q, %t want %q, %t`, nm, v, ok, v2, len(v2) != 0)
		}
		if v, ok := c.Value(k3).(string); ok == (len(v3) == 0) || v != v3 {
			fmt.Errorf(`%s.Value(k3).(string) = %q, %t want %q, %t`, nm, v, ok, v3, len(v3) != 0)
		}
	}
	c0 := context.Background()
	check(c0, "c0", "", "", "")
	c1 := context.WithValue(context.Background(), k1, "c1k1")
	check(c1, "c1", "c1k1", "", "")

	c2 := context.WithValue(c1, k2, "c2k2")
	check(c2, "c2", "c1k1", "c2k2", "")

	c3 := context.WithValue(c2, k3, "c3k3")
	check(c3, "c2", "c1k1", "c2k2", "c3k3")

	c4 := context.WithValue(c3, k1, nil)
	check(c4, "c4", "", "c2k2", "c3k3")

	o0 := otherContext{context.Background()}
	check(o0, "o0", "", "", "")

	o1 := otherContext{context.WithValue(context.Background(), k1, "c1k1")}
	check(o1, "o1", "c1k1", "", "")

	o2 := context.WithValue(o1, k2, "o2k2")
	check(o2, "o2", "c1k1", "o2k2", "")

	o3 := otherContext{c4}
	check(o3, "o3", "", "c2k2", "c3k3")

	o4 := context.WithValue(o3, k3, nil)
	check(o4, "o4", "", "c2k2", "")

}

func TestSimultaneousCancels() {
	root, cancel := context.WithCancel(context.Background())

	m := map[context.Context]context.CancelFunc{root: cancel}
	q := []context.Context{root}

	for len(q) != 0 && len(m) < 100 {
		parent := q[0]
		q := q[1:]
		for i := 0; i < 4; i++ {
			ctx, cancel := context.WithCancel(parent)
			m[ctx] = cancel
			q = append(q, ctx)
		}
	}
	var wg sync.WaitGroup
	wg.Add(len(m))
	for _, cancel := range m {
		go func(cancel context.CancelFunc) {
			cancel()
			wg.Done()
		}(cancel)
	}

	d := 5 * time.Second
	stuck := make(chan struct{})
	timer := time.AfterFunc(d, func() { close(stuck) })
	defer timer.Stop()

	for ctx := range m {
		select {
		case <-ctx.Done():
		case <-stuck:
			buf := make([]byte, 10<<10)
			n := runtime.Stack(buf, true)
			fmt.Errorf("timed out after %v waiting for <-ctx.Done(); stacks:\n%s", d, buf[:n])
		}
	}

	done := make(chan struct{})
	go func() {
		wg.Wait()
		close(done)
	}()

	select {
	case <-done:
	case <-stuck:
		buf := make([]byte, 10<<10)
		n := runtime.Stack(buf, true)
		fmt.Errorf("timed out after %v waiting for cancel functions; stacks:\n%s", d, buf[:n])
	}

}

func TestInterlockedCancels() {
	parent, cancelParent := context.WithCancel(context.Background())
	child, cancelChild := context.WithCancel(parent)
	go func() {
		<-parent.Done()
		cancelChild()
	}()
	cancelParent()
	d := 5 * time.Second
	timer := time.NewTimer(d)
	defer timer.Stop()
	select {
	case <-child.Done():
	case <-timer.C:
		buf := make([]byte, 10<<10)
		n := runtime.Stack(buf, true)
		fmt.Errorf("timed out after %v waiting for child.Done(); stacks:\n%s", d, buf[:n])
	}
}

func TestLayersCancel() {
	testLayers(time.Now().UnixNano(), false)
}

func TestLayersTimeout() {
	testLayers(time.Now().UnixNano(), true)
}
func testLayers(seed int64, testTimeout bool) {
	r := rand.New(rand.NewSource(seed))
	errorf := func(format string, a ...any) {
		fmt.Errorf(fmt.Sprintf("seed=%d: %s", seed, format), a...)
	}
	const (
		minLayers = 30
	)
	type value int
	var (
		vals      []*value
		cancels   []context.CancelFunc
		numTimers int
		ctx       = context.Background()
		ctxs      []context.Context
	)
	for i := 0; i < minLayers || numTimers == 0 || len(cancels) == 0 || len(vals) == 0; i++ {
		switch r.Intn(3) {
		case 0:
			v := new(value)
			ctx = context.WithValue(ctx, v, v)
			vals = append(vals, v)
			ctxs = append(ctxs, ctx)
		case 1:
			var cancel context.CancelFunc
			ctx, cancel = context.WithCancel(ctx)
			cancels = append(cancels, cancel)
			ctxs = append(ctxs, ctx)
		case 2:
			var cancel context.CancelFunc
			d := veryLongDuration
			if testTimeout {
				d = shortDuration
			}
			ctx, cancel = context.WithTimeout(ctx, d)
			cancels = append(cancels, cancel)
			ctxs = append(ctxs, ctx)
			numTimers++
		}
	}
	checkValues := func(when string) {
		for _, key := range vals {
			if val := ctx.Value(key).(*value); key != val {
				errorf("%s: ctx.Value(%p) = %p want %p", when, key, val, key)
			}
		}
	}
	if !testTimeout {
		select {
		case <-ctx.Done():
			errorf("ctx should not be canceled yet")
		default:
		}
	}
	checkValues("before cancel")
	if testTimeout {
		d := 5 * time.Second
		timer := time.NewTimer(d)
		defer timer.Stop()
		select {
		case <-ctx.Done():
		case <-timer.C:
			errorf("ctx should have timed out after %v", d)
		}
		checkValues("after timeout")
	} else {
		cancel := cancels[r.Intn(len(cancels))]
		cancel()
		select {
		case <-ctx.Done():
		default:
			errorf("ctx should be canceled")
		}
		checkValues("after cancel")
	}

}

type myCtx struct {
	context.Context
}
type myDoneCtx struct {
	context.Context
}

func (d *myDoneCtx) Done() <-chan struct{} {
	c := make(chan struct{})
	return c
}

var goroutines int32

func TestCustomContextGoroutines() {
	g := atomic.LoadInt32(&goroutines)
	checkNoGoroutine := func() {
		now := atomic.LoadInt32(&goroutines)
		if now != g {
			fmt.Errorf("%d goroutines created", now-g)
		}
	}
	checkCreatedGoroutine := func() {
		now := atomic.LoadInt32(&goroutines)
		if now != g+1 {
			fmt.Errorf("%d goroutines created, want 1", now-g)
		}
		g = now
	}
	_, cancel0 := context.WithCancel(&myDoneCtx{context.Background()})
	cancel0()
	checkCreatedGoroutine()

	_, cancel0 = context.WithTimeout(&myDoneCtx{context.Background()}, veryLongDuration)
	cancel0()
	checkCreatedGoroutine()

	checkNoGoroutine()
	defer checkNoGoroutine()

	ctx1, cancel1 := context.WithCancel(context.Background())
	defer cancel1()
	checkNoGoroutine()

	ctx2 := &myCtx{ctx1}
	ctx3, cancel3 := context.WithCancel(ctx2)
	defer cancel3()
	checkNoGoroutine()

	_, cancel3b := context.WithCancel(&myDoneCtx{ctx2})
	defer cancel3b()
	checkCreatedGoroutine()

	ctx4, cancel4 := context.WithTimeout(ctx3, veryLongDuration)
	defer cancel4()
	checkNoGoroutine()

	ctx5, cancel5 := context.WithCancel(ctx4)
	defer cancel5()
	checkNoGoroutine()

	cancel5()
	checkNoGoroutine()

	_, cancel6 := context.WithTimeout(ctx5, veryLongDuration)
	defer cancel6()
	checkNoGoroutine()

	// Check applied to canceled context.
	cancel6()
	cancel1()
	_, cancel7 := context.WithCancel(ctx5)
	defer cancel7()
	checkNoGoroutine()

}
