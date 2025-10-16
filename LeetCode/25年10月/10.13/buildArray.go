package temp

func buildArray(target []int, n int) []string {
	len := len(target)

	ans := make([]string, 0, len)
	index := 0 //target的index记录
	for i := 1; i <= n; i++ {
		if i > target[len-1] {
			break //结束循环
		}

		if i == target[index] {
			ans = append(ans, "Push")
			index++
		} else {
			ans = append(ans, "Push", "Pop")
		}

	}
	return ans
}
