package temp

func trap(height []int) (ans int) {
	n := len(height)

	left := 0
	right := n - 1
	leftMax, rightMax := 0, 0

	for left < right {
		leftMax = max(leftMax, height[left])
		rightMax = max(rightMax, height[right])

		if height[left] < height[right] {
			ans += leftMax - height[left]
			left++
		} else {
			ans += rightMax - height[right]
			right--
		}
	}
	return
}
