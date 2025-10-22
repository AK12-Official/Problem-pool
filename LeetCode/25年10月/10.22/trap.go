package temp

func trapDP(height []int) (ans int) {
	n := len(height)
	if n == 1 {
		return 0
	}

	prefixArr := ProcessPrefixMax(height)
	suffixArr := ProcessSuffixMax(height)

	idx := 0
	for prefixArr[idx] != suffixArr[idx] {
		idx++
	}
	heighest := prefixArr[idx]

	DiffSum := 0
	Sum := 0
	for i := 0; i < n; i++ {
		DiffSum += abs(prefixArr[i] - suffixArr[i])
		Sum += height[i]
	}

	ans = int(int64(heighest*n - DiffSum - Sum))

	return
}

func abs(x int) int {
	if x > 0 {
		return x
	}
	return -x
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
