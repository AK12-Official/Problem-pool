package temp

func numPairsDivisibleBy60(time []int) int {
	m := new([60]int)

	ans := 0
	for _, v := range time {
		t := v % 60
		ans += m[(60-t)%60]
		m[t]++
	}
	return ans
}
