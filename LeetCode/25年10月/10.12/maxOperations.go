package temp

func maxOperations(nums []int, k int) int {
	ops := 0
	m := make(map[int]int)

	len := len(nums)

	for i := 0; i < len; i++ {
		if _, ok := m[k-nums[i]]; ok {
			ops++
			m[k-nums[i]]--
			if m[k-nums[i]] == 0 {
				delete(m, k-nums[i])
			}
		} else {
			m[nums[i]]++
		}
	}
	return ops
} //29ms

func maxOperationsPro(nums []int, k int) int {
	ops := 0
	n := len(nums)
	m := make(map[int]int, n) // 预分配容量

	for _, x := range nums {
		need := k - x
		if cnt := m[need]; cnt > 0 {
			ops++
			if cnt == 1 {
				delete(m, need)
			} else {
				m[need] = cnt - 1
			}
		} else {
			m[x]++
		}
	}
	return ops
} //23ms
