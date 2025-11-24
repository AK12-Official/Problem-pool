package temp

import "unicode"

func findLongestSubarray(array []string) []string {
	preCnt := 0
	mp := make(map[int]int)
	mp[0] = -1

	beginIndex, endIndex := 0, -1

	for i, v := range array {
		r := []rune(v)
		if len(r) > 0 && unicode.IsLetter(r[0]) {
			preCnt--
		} else {
			preCnt++
		}

		if value, ok := mp[preCnt]; ok {
			if i-value > endIndex-beginIndex+1 {
				beginIndex = value + 1
				endIndex = i
			}
		} else {
			mp[preCnt] = i
		}
	}
	if endIndex == -1 {
		return []string{}
	}
	return array[beginIndex : endIndex+1]
}
