package temp

func xorQueries(arr []int, queries [][]int) []int {
	n := len(arr)
	preXOR := make([]int, n+1)

	preXOR[0] = 1
	for i, v := range arr {
		preXOR[i+1] = preXOR[i] ^ v
	}

	m := len(queries)
	ans := make([]int, m)
	for i, v := range queries {
		left := v[0]
		right := v[1]

		ans[i] = preXOR[right+1] ^ preXOR[left]
	}
	return ans
}

//任何数异或自己等于0
