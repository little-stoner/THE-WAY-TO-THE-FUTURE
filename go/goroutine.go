package main

import (
	"fmt"
	"syscall"
	"runtime"
	"strconv"
	"bytes"
)

func getGID() uint64 {
    b := make([]byte, 64)
    b = b[:runtime.Stack(b, false)]
    b = bytes.TrimPrefix(b, []byte("goroutine "))
    b = b[:bytes.IndexByte(b, ' ')]
    n, _ := strconv.ParseUint(string(b), 10, 64)
    return n
}

func block(c chan bool) {
	fmt.Println(" block() enter...... ======> ", getGID())
	buf := make([]byte, 1024)
	_, _ = syscall.Read(0, buf)  // block on doing an unbuffered read on STDIN
	fmt.Println(" block() exit ")
	c <- true                    // done
}

func main() {
	c := make(chan bool)
	for i := 0; i < 10; i++ {
		go block(c);
	}
	fmt.Println(" ======================================================================== ")
	for i := 0; i < 10; i++ {
		_ = <-c
	}
}
