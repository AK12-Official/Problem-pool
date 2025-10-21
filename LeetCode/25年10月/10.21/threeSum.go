package temp

import "sort"

func threeSum(nums []int) [][]int {
	n := len(nums)
	ret := make([][]int, 0, n*3)

	sort.Ints(nums)

	for i := 0; i < n-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		left := i + 1
		right := n - 1

		for left < right {

			val := nums[i] + nums[left] + nums[right]
			if val == 0 {
				temp := []int{nums[i], nums[left], nums[right]}
				ret = append(ret, temp)

				left++
				right--
				for left < right && nums[left] == nums[left-1] {
					left++
				}
				for left < right && nums[right] == nums[right+1] {
					right--
				}
			} else if val < 0 {
				left++
			} else {
				right--
			}
		}
	}
	return ret
}
