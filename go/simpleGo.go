package main

import (
	"fmt"
	"time"
)

func say(myName string) {
	for i := 0; i < 5; i++ {
		time.Sleep(100 * time.Millisecond)
		fmt.Println(myName)
	}
}

func main() {
	go say("world")
	say(" >>>> hello")
}
