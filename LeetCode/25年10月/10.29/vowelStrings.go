package temp

func vowelStrings(words []string, queries [][]int) []int {
	n := len(words)
	record := make([]int, n)

	if vowelWord(words[0]) {
		record[0] = 1
	}
	for i := 1; i < n; i++ {
		if vowelWord(words[i]) {
			record[i] = record[i-1] + 1
		} else {
			record[i] = record[i-1]
		}
	}

	n = len(queries)
	ans := make([]int, 0, n)
	for _, v := range queries {
		num := 0
		if vowelWord(words[v[0]]) {
			num = record[v[1]] - record[v[0]] + 1
		} else {
			num = record[v[1]] - record[v[0]]
		}
		ans = append(ans, num)
	}
	return ans
}

func vowelWord(str string) bool {
	begin := str[0]
	end := str[len(str)-1]
	switch begin {
	case 'a', 'e', 'i', 'o', 'u':
		switch end {
		case 'a', 'e', 'i', 'o', 'u':
			return true
		}
	}
	return false
}
