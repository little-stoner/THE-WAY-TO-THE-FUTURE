package main

import "golang.org/x/tour/tree"
import "fmt"
import "sort"

func WalkImpl0(t *tree.Tree, ch chan int) {
	
}

func WalkImpl(t *tree.Tree, ch chan int) {
	if t == nil {
		return
	}
	ch<- t.Value
	WalkImpl(t.Left, ch)
	WalkImpl(t.Right, ch)
}

func Walk(t *tree.Tree, ch chan int) {
	if t == nil {
		return
	}
	ch<- t.Value
	WalkImpl(t.Left, ch)
	WalkImpl(t.Right, ch)
	close(ch)
}

func Same(t1, t2 *tree.Tree) bool {
	ch1 := make(chan int)
	ch2 := make(chan int)
	go Walk(t1, ch1)
	go Walk(t2, ch2)
	for i := range ch1 {
		a1 = append(a1, i)
	}
	for j := range ch2 {
		a2 = append(a2, j)
	}
	sort.Ints(a1)
	sort.Ints(a2)
	fmt.Println(">>>>>> ", a1)
	fmt.Println(">>>>>> ", a2)
	for k, v := range a1 {
		if v != a2[k] {
			fmt.Println(" fuck !! ")
			return false
		}
	}
	fmt.Println(" ok ");
	return true
}

func main() {
  Same(tree.New(1), tree.New(1))
}
