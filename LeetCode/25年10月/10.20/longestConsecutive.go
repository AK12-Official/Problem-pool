package temp

import "sort"

func longestConsecutive(nums []int) (ans int) {

	sort.Ints(nums)
	m := make(map[int]int)

	for _, v := range nums {
		if _, ok := m[v-1]; ok {
			m[v] = m[v-1] + 1
		} else {
			m[v] = 1
		}
	}

	for _, v := range m {
		if v > ans {
			ans = v
		}
	}
	return
}
