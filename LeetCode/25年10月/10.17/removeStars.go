package temp

func removeStars(s string) string {
	n := len(s)
	ans := make([]byte, 0, n)

	for _, v := range s {
		if v == '*' {
			ans = ans[:len(ans)-1]
		} else {
			ans = append(ans, byte(v))
		}
	}

	return string(ans)
}
