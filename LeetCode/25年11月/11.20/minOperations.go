package temp

import "sort"

func minOperations(nums []int, queries []int) []int64 {

	sort.Ints(nums)

	m := len(nums)
	n := len(queries)
	pre := make([]int, m+1)
	ans := make([]int64, n)

	for i, v := range nums {
		pre[i+1] = pre[i] + v
	}

	for i, v := range queries {

		index := sort.Search(m, func(j int) bool {
			return nums[j] >= v
		})

		left := v*index - pre[index]
		right := pre[m] - pre[index] - v*(m-index)

		ans[i] = int64(left + right)
	}
	return ans
}
