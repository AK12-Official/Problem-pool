package temp

func countCompleteDayPairs(hours []int) (ans int64) {
	m := new([24]int)

	for _, v := range hours {
		ans += int64(m[(24-(v%24))%24])
		m[v%24]++
	}
	return
}
