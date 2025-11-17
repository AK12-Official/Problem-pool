package temp

func getSumAbsoluteDifferences(nums []int) []int {
	sum := 0
	for _, v := range nums {
		sum += v
	}

	n := len(nums)
	ans := make([]int, n)

	preSum := 0
	for i, v := range nums {
		ans[i] = v*i - preSum + (sum - preSum - v) - v*(n-i-1)
		preSum += v
	}
	return ans
}
