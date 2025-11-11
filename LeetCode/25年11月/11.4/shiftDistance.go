package temp

func shiftDistance(s string, t string, nextCost []int, previousCost []int) int64 {
	goAfter := ProcessPrefixSum(nextCost)     // nextCost 前缀
	goAhead := ProcessPrefixSum(previousCost) // previousCost 前缀

	n := 26
	var ans int64
	for i := 0; i < len(s); i++ {
		if s[i] == t[i] {
			continue
		}
		sb := int(s[i] - 'a')
		tb := int(t[i] - 'a')

		var costGoAhead int
		var costGoBehind int
		if tb > sb {
			costGoBehind = goAfter[tb] - goAfter[sb]
			costGoAhead = goAhead[n] - goAhead[tb+1] + goAhead[sb+1]
		} else {
			costGoBehind = goAfter[n] - goAfter[sb] + goAfter[tb]
			costGoAhead = goAhead[sb+1] - goAhead[tb+1]
		}
		ans += int64(min(costGoAhead, costGoBehind))
	}
	return ans
}

func ProcessPrefixSum(nums []int) []int {
	n := len(nums)
	prefix := make([]int, n+1)
	prefix[0] = 0
	for i := 0; i < n; i++ {
		prefix[i+1] = prefix[i] + nums[i]
	}
	return prefix
}
