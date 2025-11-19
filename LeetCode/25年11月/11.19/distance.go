package temp

func distance(nums []int) []int64 {
	mp := make(map[int][]int)

	for i, v := range nums {
		mp[v] = append(mp[v], i)
	}

	ans := make([]int64, len(nums))

	for _, v := range mp {
		n := len(v)
		prefix := make([]int, n+1)

		for index, value := range v {
			prefix[index+1] = prefix[index] + value
		}

		for index, value := range v {
			left := index*value - prefix[index]
			right := prefix[n] - (n-index)*value - prefix[index]
			ans[value] = int64(left + right)
		}
	}
	return ans
}
