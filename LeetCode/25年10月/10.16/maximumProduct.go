package temp

func maximumProduct(nums []int, m int) int64 {
	n := len(nums)

	if m == 1 {
		maxVal := abs(nums[0])
		for i := 1; i < n; i++ {
			if abs(nums[i]) > maxVal {
				maxVal = abs(nums[i])
			}
		}
		return int64(maxVal) * int64(maxVal)
	}

	preMax := nums[0]
	preMin := nums[0]
	var ans int64 = -1e12
	for i := 0; i+m-1 < n; i++ {
		curr := nums[i+m-1]

		ans = max(ans, int64(curr*preMax))
		ans = max(ans, int64(curr*preMin))

		preMax = max(preMax, nums[i])
		preMin = min(preMin, nums[i])
	}
	return ans
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
