package temp

func countValidSelections(nums []int) (ans int) {
	if len(nums) == 1 {
		return 2
	}
	preSum := make([]int, len(nums))
	preSum[0] = nums[0]
	sum := nums[0]
	for i := 1; i < len(nums); i++ {
		preSum[i] = preSum[i-1] + nums[i]
		sum += nums[i]
	}

	for i, v := range nums {
		if v == 0 {
			leftSum := 0
			if i > 0 {
				leftSum = preSum[i-1]
			}
			rightSum := sum - leftSum
			if leftSum == rightSum {
				ans += 2
			} else if DIff(leftSum, rightSum) == 1 {
				ans++
			}
		}
	}

	return
}

func DIff(leftSum, rightSum int) int {
	if leftSum > rightSum {
		return leftSum - rightSum
	}
	return rightSum - leftSum
}

func countValidSelectionsPro(nums []int) (ans int) {
	if len(nums) == 1 {
		return 2
	}
	sum := 0
	for _, v := range nums {
		sum += v
	}

	preSum := 0
	for _, v := range nums {
		if v == 0 {
			if sum == preSum {
				ans += 2
			}
			if (sum-preSum) == 1 || (preSum-sum) == 1 {
				ans++
			}
		} else {
			preSum += v
			sum -= v
		}
	}
	return
}
