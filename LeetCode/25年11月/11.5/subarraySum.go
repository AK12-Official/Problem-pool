package temp

func subarraySum(nums []int, k int) int {
	preSum := 0
	m := make(map[int]int)
	m[0] = 1

	ans := 0
	for _, v := range nums {
		preSum += v
		if cnt, ok := m[preSum-k]; ok {
			ans += cnt
		}
		m[preSum]++
	}

	return ans
}
