package main

import (
	"fmt"
    "strconv"
	"time"
)

func main() {
	c := make(chan string)

	go func(){
		for j := 0; j < 10; j++ {
			fmt.Println(" before send to #1 ")
			c <- ("#1: " + strconv.Itoa(j))
			fmt.Println(" after send to #1 ")			
		}
		fmt.Println(" close #1 ")		
		//close(c)
	}()
	go func() {
		for i := 0; i < 5; i++ {
			fmt.Println(" before send to #2 ")			
			c <- ("#2: " + strconv.Itoa(i))
			fmt.Println(" after send to #1 ")			
		}
		fmt.Println(" close #2 ")				
		//close(c)
	} ()

	fmt.Println(" ================ ")

	time.Sleep(1000 * time.Millisecond)
	//for r := range c {
	//for {
	for i := 0 ; i < 15; i++ {
		fmt.Println(" before fetch ")
		fmt.Println(" #####: ", <-c)
		fmt.Println(" after fetch ")
		fmt.Println(" ************* ")
		fmt.Println()
	}
	
}
