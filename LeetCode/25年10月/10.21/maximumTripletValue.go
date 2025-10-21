package temp

func maximumTripletValue(nums []int) (ans int64) {

	prefixArr := ProcessPrefixMax(nums)
	suffixArr := ProcessSuffixMax(nums)

	ans = 0
	for i := 1; i < len(nums)-1; i++ {
		ans = max(int64((prefixArr[i-1]-nums[i])*suffixArr[i+1]), ans)
	}
	return
}

func ProcessPrefixMax(nums []int) []int {
	n := len(nums)
	prefix := make([]int, n)
	prefix[0] = nums[0]
	for i := 1; i < n; i++ {
		prefix[i] = max(prefix[i-1], nums[i])
	}
	return prefix
}

func ProcessSuffixMax(nums []int) []int {
	n := len(nums)
	suffix := make([]int, n)
	suffix[n-1] = nums[n-1]
	for i := n - 2; i >= 0; i-- {
		suffix[i] = max(suffix[i+1], nums[i])
	}
	return suffix
}

//一样的性能感人着一块
