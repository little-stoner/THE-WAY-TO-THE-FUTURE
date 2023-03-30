package gogeneric

import (
	"fmt"
	"reflect"
)

func main() {
	ints := map[string]int64{
		"first":  34,
		"second": 12,
	}

	// Initialize a map for the float values
	floats := map[string]float64{
		"first":  35.98,
		"second": 26.99,
	}
	fmt.Printf("Generic Sums: %v and %v\n",
		SumIntsOrFloats[string, int64](ints),
		SumIntsOrFloats[string, float64](floats))

	m := map[int]string{1: "2", 2: "4", 3: "8"}
	fmt.Println(" keys: ", MapKeys(m))
}

func MapKeys[K comparable, V any](m map[K]V) []K {
	r := make([]K, 0, len(m))
	for k := range m {
		r = append(r, k)
	}
	return r
}

func SumIntsOrFloats[K comparable, V any](m map[K]V) V {
	var s V
	for _, v := range m {
		s += v
	}
	fmt.Printf(">>>>>>> %s \n", reflect.TypeOf(s))
	return s
}

func SumInts(m map[string]int64) int64 {
	var s int64
	for _, v := range m {
		s += v
	}
	return s
}

func sumFloats(m map[string]float64) float64 {
	var s float64
	for _, v := range m {
		s += v
	}
	return s
}
