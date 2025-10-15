package temp

func maxScoreSightseeingPair(values []int) int {
	//省去中间的切片处理
	n := len(values)
	if n == 0 {
		return 0
	}

	preMax := values[0] + 0
	ans := 0

	for i := 1; i < n; i++ {
		candidate := preMax + values[i] - i
		if candidate > ans {
			ans = candidate
		}
		if values[i]+i > preMax {
			preMax = values[i] + i
		}
	}
	return ans
}
