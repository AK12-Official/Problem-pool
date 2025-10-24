package temp

func countPalindromicSubsequence(s string) (ans int) {

	suf := make(map[rune]int)
	for _, x := range s {
		suf[x]++
	}

	record := make(map[string]int)
	pre := make(map[rune]int)
	for _, x := range s {
		suf[x]--

		for k := range pre {
			if v, ok := suf[k]; ok && v > 0 {
				str := string([]rune{k, x, k})
				if _, ok := record[str]; !ok {
					ans++
					record[str]++
				}
			}
		}
		pre[x]++
	}

	return
}
