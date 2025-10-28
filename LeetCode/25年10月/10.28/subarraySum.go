package temp

func subarraySum(nums []int) int {
	n := len(nums)
	preSum := make([]int, n)
	preSum[0] = nums[0]
	for i := 1; i < n; i++ {
		preSum[i] = preSum[i-1] + nums[i]
	}

	ans := 0
	for i, v := range nums {
		start := max(0, i-v)
		if start > 0 {
			ans += preSum[i] - preSum[start-1]
		} else {
			ans += preSum[i]
		}
	}
	return ans
}
