package temp

func countBadPairs(nums []int) int64 {

	m := make(map[int]int)

	for i, v := range nums {
		m[v-i]++
	}

	if len(m) == 1 {
		return 0
	}

	var ans int64 = 0
	n := len(nums)
	for _, v := range m {
		if n != v {
			ans += int64(v) * int64(n-v)
			n -= v
		}
	}
	return ans

}

func countBadPairsPro(nums []int) int64 {
	m := make(map[int]int)

	for i, v := range nums {
		m[v-i]++
	}

	if len(m) == 1 {
		return 0
	}

	n := len(nums)
	var totalPairs int64 = int64(n * (n - 1) / 2)
	var goodPairs int64 = 0
	for _, v := range m {
		goodPairs += int64(v * (v - 1) / 2)
	}
	return totalPairs - goodPairs
}
