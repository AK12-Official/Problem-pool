package temp

func minimumSum(nums []int) int {
	prefixArr := ProcessPrefixMin(nums)
	suffixArr := ProcessSuffixMin(nums)

	ans := -1
	for i := 1; i < len(nums)-1; i++ {
		if nums[i] > prefixArr[i-1] && nums[i] > suffixArr[i+1] {
			if ans == -1 {
				ans = nums[i] + prefixArr[i-1] + suffixArr[i+1]
			} else {
				ans = min(ans, nums[i]+prefixArr[i-1]+suffixArr[i+1])
			}
		}
	}
	return ans
}

func ProcessPrefixMin(nums []int) []int {
	n := len(nums)
	prefix := make([]int, n)
	prefix[0] = nums[0]
	for i := 1; i < n; i++ {
		prefix[i] = min(prefix[i-1], nums[i])
	}
	return prefix
}

func ProcessSuffixMin(nums []int) []int {
	n := len(nums)
	suffix := make([]int, n)
	suffix[n-1] = nums[n-1]
	for i := n - 2; i >= 0; i-- {
		suffix[i] = min(suffix[i+1], nums[i])
	}
	return suffix
}
