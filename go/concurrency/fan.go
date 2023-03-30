package concurrency

import (
	"sync"
)

func repeatFn(
	done <-chan interface{},
	fn func() interface{},
) <-chan interface{} {
	valueStream := make(chan interface{})
	go func() {
		defer close(valueStream)
		for {
			select {
			case <-done:
				return
			case valueStream <- fn():
			}
		}
	}()
	return valueStream

}

//func fan() {
//	rand := func() interface{} { return rand.Intn(5000000) }
//	done := make(chan interface{})
//	defer close(done)
//
//	start := time.Now()
//	randIntStream := toInt(done, repeatFn(done, rand))
//	fmt.Println("Primes:")
//	for prime := range take(done, primeFinder(done, randIntStream), 10) {
//		fmt.Printf("\t%d\n", prime)
//	}
//	fmt.Printf("Search took: %v", time.Since(start))
//}
//
//func fanfan() {
//	primeStream := primeFinder(done, randIntStream)
//	numFinders := runtime.NumCPU()
//	finders := make([]<-chan int, numFinders)
//	for i := 0; i < numFinders; i++ {
//		finders[i] = primeFinder(done, randIntStream)
//	}
//}

func fanIn(
	done <-chan interface{},
	channels ...<-chan interface{},
) <-chan interface{} {
	var wg sync.WaitGroup
	multiplexedStream := make(chan interface{})
	multiplex := func(c <-chan interface{}) {
		defer wg.Done()
		for i := range c {
			select {
			case <-done:
				return
			case multiplexedStream <- i:
			}
		}
	}
	wg.Add(len(channels))
	for _, c := range channels {
		go multiplex(c)
	}
	go func() {
		wg.Wait()
		close(multiplexedStream)
	}()
	return multiplexedStream
}

func fanInfanIn() {
	//
	//done := make(chan interface{})
	//defer close(done)
	//start := time.Now()
	//rand := func() interface{} { return rand.Intn(50000000) }
	//randIntStream := toInt(done, repeatFn(done, rand))
	//numFinders := runtime.NumCPU()
	//fmt.Printf("Spinning up %d prime finders.\n", numFinders)
	//finders := make([]<-chan interface{}, numFinders)
	//fmt.Println("Primes:")
	//for i := 0; i < numFinders; i++ {
	//	finders[i] = primeFinder(done, randIntStream)
	//}
	//for prime := range take(done, fanIn(done, finders...), 10) {
	//	fmt.Printf("\t%d\n", prime)
	//}
	//fmt.Printf("Search took: %v", time.Since(start))
}
