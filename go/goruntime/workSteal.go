package goruntime

import "fmt"

/*

	steal work from work-queue (deque)

*/

func workSteal() {
	fmt.Printf("fib(4) = %d", <-fib(4))
}

func fib(n int) <-chan int {
	result := make(chan int)
	go func() {
		defer close(result)
		if n <= 2 {
			result <- 1
			return
		}
		result <- <-fib(n-1) + <-fib(n-2)
	}()
	return result
}
