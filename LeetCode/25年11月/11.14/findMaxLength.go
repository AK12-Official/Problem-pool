package temp

func findMaxLength(nums []int) (ans int) {
	preSum := 0
	mp := make(map[int]int)
	mp[0] = -1

	for i, v := range nums {
		switch v {
		case 0:
			preSum--
		case 1:
			preSum++
		}

		if value, ok := mp[preSum]; ok {
			ans = max(ans, i-value)
		} else {
			mp[preSum] = i
		}
	}
	return
}
