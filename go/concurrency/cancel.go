package concurrency

func e() {
	var value interface{}
	var done chan interface{}
	valueStream := make(chan int)
	resultStream := make(chan int)
	defer close(done)
	select {
	case <-done:
		return
	case value = <-valueStream:
	}
	result := reallyLongCalculation(done, value)
	select {
	case <-done:
		return
	case resultStream <- result.(int):
	}
}

func reallyLongCalculation(
	done <-chan interface{},
	value interface{},
) interface{} {
	intermediateResult := longCalculation(value)
	select {
	case <-done:
		return nil
	default:
	}
	return longCalculation(intermediateResult)
}

func reallyLongCalculation0(
	done <-chan interface{},
	value interface{},
) interface{} {
	intermediateResult := longCalculation0(done, value)
	return longCalculation0(done, intermediateResult)
}

func longCalculation(value interface{}) interface{} {
	return nil
}
func longCalculation0(done <-chan interface{}, value interface{}) interface{} {
	return nil
}
