package temp

func isArraySpecial(nums []int, queries [][]int) []bool {
	n := len(nums)

	record := make([]int, n)
	record[0] = 1
	for i := 1; i < n; i++ {
		if abs(nums[i]-nums[i-1])%2 == 1 {
			record[i] = record[i-1] + 1
		} else {
			record[i] = record[i-1]
		}
	}

	ans := make([]bool, 0, n)
	for _, v := range queries {
		len := v[1] - v[0]
		if record[v[1]]-record[v[0]] == len {
			ans = append(ans, true)
		} else {
			ans = append(ans, false)
		}
	}
	return ans
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
