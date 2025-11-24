package temp

func checkSubarraySum(nums []int, k int) bool {
	preSum := 0
	m := make(map[int]int)
	m[0] = 1

	for _, v := range nums {
		preSum += v

		if v%k == 0 {
			if m[preSum%k] >= 2 {
				return true
			}
		} else {
			if _, ok := m[preSum%k]; ok {
				return true
			}
		}

		m[preSum%k]++
	}
	return false
}
