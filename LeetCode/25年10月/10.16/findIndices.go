package temp

func findIndices(nums []int, indexDifference int, valueDifference int) []int {
	n := len(nums)

	preMax := []int{nums[0], 0}
	preMin := []int{nums[0], 0}

	for i := indexDifference; i < n; i++ {
		if abs(nums[i]-preMax[0]) >= valueDifference {
			return []int{preMax[1], i}
		}

		if abs(nums[i]-preMin[0]) >= valueDifference {
			return []int{preMin[1], i}
		}

		if nums[i-indexDifference] > preMax[0] {
			preMax[0] = nums[i]
			preMax[1] = i
		}

		if nums[i-indexDifference] < preMin[0] {
			preMin[0] = nums[i]
			preMin[1] = i
		}
	}
	return []int{-1, -1}
}
