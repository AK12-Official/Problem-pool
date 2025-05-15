package sqrt

import (
	"fmt"
	"math"
)

func Sqrt(x float64) float64 {

	if x < 0 {
		return -1
	} else if x == 0 {
		return 0
	}

	z := 1.0
	pre := float64(z)
	maxIter := 100   // 最大迭代次数
	epsilon := 1e-10 // 精度要求

	for i := 0; i < maxIter; i++ {
		z -= (z*z - x) / (2 * z)
		delta := math.Abs(z - pre)
		fmt.Println(delta)
		fmt.Println(z)
		if delta < epsilon {
			return z
		}
		pre = z
	}
	return z
}

func main() {
	fmt.Println(Sqrt(2))
}
