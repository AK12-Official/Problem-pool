package temp

type NumArray struct {
	preSumArr []int
}

func Constructor(nums []int) NumArray {
	n := len(nums)
	arr := make([]int, n)
	arr[0] = nums[0]
	for i := 1; i < n; i++ {
		arr[i] = arr[i-1] + nums[i]
	}
	return NumArray{
		arr,
	}
}

func (this *NumArray) SumRange(left int, right int) int {
	if left > 0 {
		return this.preSumArr[right] - this.preSumArr[left-1]
	} else {
		return this.preSumArr[right]
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */
