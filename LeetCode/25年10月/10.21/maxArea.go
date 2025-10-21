package temp

func maxArea(height []int) (ans int) {
	n := len(height)

	right := n - 1
	left := 0

	for left < right {
		ans = max((right-left)*min(height[left], height[right]), ans)
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return
}
