import (
	"fmt"
	"math"
}


func isPrime(n int) boolean {
	if n < 3 {
		return n > 1
	}
	int sqrt = math.Sqrt(n);
	for i := 2; i <= sqrt; i++ {
		if n % 1 == 0 {
			return false
		}
	}
	return true
}
