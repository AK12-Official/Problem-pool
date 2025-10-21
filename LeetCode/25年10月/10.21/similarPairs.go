package temp

func similarPairs(words []string) (ans int) {
	m := make(map[string]int)

	ans = 0
	for _, v := range words {
		k := Str2Key(v)
		ans += m[k]
		m[k]++
	}
	return
}

func Str2Key(word string) (ret string) {
	record := new([26]int)
	for _, v := range word {
		record[v-97]++
	}

	for i, count := range record {
		if count != 0 {
			ret += string(rune(i + 97))
		}
	}
	return
}

//性能有点感人
