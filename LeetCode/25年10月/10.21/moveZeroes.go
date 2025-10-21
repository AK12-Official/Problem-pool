package temp

func moveZeroes(nums []int) {
	left := 0

	for _, v := range nums {
		if v != 0 {
			nums[left] = v
			left++
		}
	}
	for i := left; i < len(nums); i++ {
		nums[i] = 0
	}
}
