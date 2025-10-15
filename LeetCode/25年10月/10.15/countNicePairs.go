package temp

func countNicePairs(nums []int) int {
	const MOD int64 = 1_000_000_007
	m := make(map[int]int)

	for _, v := range nums {
		m[v-rev(v)]++
	}

	var ans int64 = 0
	for _, v := range m {
		ans = (ans + int64(v*(v-1)/2)) % MOD
	}
	return int(ans)
}

func rev(num int) (ans int) {
	ans = 0
	for num != 0 {
		ans = ans*10 + num%10
		num /= 10
	}
	return
}
