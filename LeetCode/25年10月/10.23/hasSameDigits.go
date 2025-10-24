package temp

func hasSameDigits(s string) bool {
	n := len(s)
	record := make([][]int, n-1)
	for i := range record {
		record[i] = make([]int, n)
	}

	for i := 0; i < n; i++ {
		record[0][i] = int(s[i] - '0')
	}

	for k := 1; k < n-1; k++ {
		for i := 0; i < n-k; i++ {
			record[k][i] = (record[k-1][i] + record[k-1][i+1]) % 10
		}
	}

	return record[n-2][0] == record[n-2][1]
}
