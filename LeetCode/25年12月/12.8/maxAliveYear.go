package temp

func maxAliveYear(birth []int, death []int) int {
	rec := make([]int, 102)

	for i, v := range birth {
		b := v - 1900
		d := death[i] - 1900

		rec[b]++
		rec[d+1]--
	}

	for i := 0; i < 100; i++ {
		rec[i+1] = rec[i+1] + rec[i]
	}

	ans := 0
	max := rec[0]
	for i, v := range rec {
		if v > max {
			max = v
			ans = 1900 + i
		}
	}
	return ans
}
