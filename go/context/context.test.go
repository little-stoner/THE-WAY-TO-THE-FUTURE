package main

import (
	"context"
	"fmt"
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
		default:
			fmt.Printf("<-c[%d].Done() blocked, but shouldn't have\n", i)
		}
	}

	time.Sleep(3 * time.Second)
}
