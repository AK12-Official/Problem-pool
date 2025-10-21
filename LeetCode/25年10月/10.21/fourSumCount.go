package temp

func fourSumCount(nums1 []int, nums2 []int, nums3 []int, nums4 []int) (ans int) {
	n := len(nums1)

	m1 := make(map[int]int) // sum-times
	m2 := make(map[int]int)

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			m1[nums1[i]+nums2[j]]++
		}
	}

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			m2[nums3[i]+nums4[j]]++
		}
	}

	for k, v := range m1 {
		if value, ok := m2[-k]; ok {
			ans += value * v
		}
	}
	return
}

//性能也是一样的依托
