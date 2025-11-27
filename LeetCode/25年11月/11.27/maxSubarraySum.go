package temp

import "math"

func maxSubarraySum(nums []int, k int) (ans int64) {

	preSum := 0
	mp := make(map[int]int)
	mp[0] = 0

	ans = math.MinInt64
	for i, v := range nums {
		preSum += v
		mod := (i + 1) % k

		if val, ok := mp[mod]; ok {
			ans = max(ans, int64(preSum-val))
		}

		//不存在或者小于 更新
		if val, ok := mp[mod]; !ok || preSum < val {
			mp[mod] = preSum
		}
	}
	return
}
