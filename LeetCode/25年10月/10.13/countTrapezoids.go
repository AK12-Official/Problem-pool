package temp

func countTrapezoids(points [][]int) int {
	m := make(map[int]int)

	for _, point := range points {
		m[point[1]]++
	}

	const MOD int64 = 1000000007
	var ans int64 = 0
	var prefix int64 = 0

	for _, cnt := range m {
		if cnt < 2 {
			continue
		}
		pairs := int64(cnt * (cnt - 1) / 2)
		ans = (ans + prefix*pairs) % MOD
		prefix = (prefix + pairs) % MOD
	}

	return int(ans)
}
