package temp

var symbolValues = map[byte]int{'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

func romanToInt(s string) int {
	len := len(s)
	ret := 0

	for i := 0; i < len; i++ {
		curr := symbolValues[s[i]]

		if i+1 < len {
			next := symbolValues[s[i+1]]
			if curr < next {
				ret -= curr
			} else {
				ret += curr
			}
		} else {
			ret += curr
		}
	}

	return ret

}
