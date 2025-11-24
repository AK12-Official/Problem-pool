package temp

func rotate(nums []int, k int) {
	n := len(nums)
	k = k % n
	limit := n - k

	tmp := make([]int, n)
	index := 0
	for i := limit; i < n; i++ {
		tmp[index] = nums[i]
		index++
	}

	for i := 0; i < limit; i++ {
		tmp[index] = nums[i]
		index++
	}
	copy(nums, tmp)
}

func rotatePro(nums []int, k int) {
	n := len(nums)
	if n == 0 {
		return
	}
	k %= n
	if k == 0 {
		return
	}
	reverse := func(a []int, i, j int) {
		for i < j {
			a[i], a[j] = a[j], a[i]
			i++
			j--
		}
	}
	reverse(nums, 0, n-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, n-1)
}
