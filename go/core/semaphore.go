package core

import (
	"fmt"
	"time"
)

var limit = make(chan int, 3)

func semaphore()  {
	work := []func(){func() {
		fmt.Println(11111)
	}, func() {
		fmt.Println(22222)
	}, func() {
		fmt.Println(33333)
	}, func() {
		fmt.Println(44444)
	}}
	for _, w := range work {
		go func(w func()) {
			limit<- 1
			w()
			<-limit
		}(w)
	}
	time.Sleep(time.Millisecond * 4000)
}
