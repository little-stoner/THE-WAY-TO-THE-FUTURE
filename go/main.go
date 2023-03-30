package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"reflect"
	"time"
)

func main() {
	// gocontext.TestLayersCancel()

	for {
		leak()
		time.Sleep(5 * time.Second)
		return
	}

}

func leak() {
	doWork := func(strings <-chan string) <-chan interface{} {
		completed := make(chan interface{})
		go func() {
			defer fmt.Println("doWork exited.")
			defer close(completed)

			fmt.Println("start process strings")
			for s := range strings {
				fmt.Println(s)
			}

		}()
		return completed
	}
	doWork(nil)
	fmt.Println("Done.")
}

func f() {
	chanOwner := func() chan int {
		results := make(chan int, 5)
		go func() {
			defer close(results)
			for i := 0; i <= 5; i++ {
				results <- i
			}
		}()
		return results
	}
	consumer := func(results <-chan int) {
		for result := range results {
			fmt.Printf("Received: %d\n", result)
		}
		fmt.Println("Done receiving!")
	}
	results := chanOwner()
	consumer(results)
}

func structReflect() {
	typ := reflect.StructOf([]reflect.StructField{
		{
			Name: "Height",
			Type: reflect.TypeOf(float64(0)),
			Tag:  `json:"height"`,
		},
		{
			Name: "Age",
			Type: reflect.TypeOf(int(0)),
			Tag:  `json:"age"`,
		},
	})
	v := reflect.New(typ).Elem()
	v.Field(0).SetFloat(0.4)
	v.Field(1).SetInt(2)

	fmt.Println(">>>> v: ", v)

	s := v.Addr().Interface()

	fmt.Println(">>>> s: ", s)

	w := new(bytes.Buffer)

	if err := json.NewEncoder(w).Encode(s); err != nil {
		panic(err)
	}

	fmt.Printf("value: %+v\n", s)
	fmt.Printf("json:  %s", w.Bytes())
}
