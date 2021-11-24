package core

var c = make(chan int)
var a string

func f() {
	a = "hello "
	<-c
}

func happenBefore()  {
	go f()
	c <- 0
	print(a)
}
