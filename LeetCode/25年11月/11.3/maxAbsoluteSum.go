package temp

func maxAbsoluteSum(nums []int) int {
	preSum := 0
	pos := nums[0]
	for _, v := range nums {
		if preSum+v < v {
			preSum = 0
		}
		preSum += v
		pos = max(pos, preSum)
	}

	preSum = 0
	neg := nums[0]
	for _, v := range nums {
		if preSum+v > v {
			preSum = 0
		}
		preSum += v
		neg = min(neg, preSum)
	}
	return max(pos, abs(neg))
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
