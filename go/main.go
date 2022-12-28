package main

import (
    "fmt"
    "reflect"
    "bytes"
    "encoding/json"
)

func main() {

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
