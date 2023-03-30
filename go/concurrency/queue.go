package concurrency

func queue() {
	done := make(chan interface{})
	defer close(done)

}
