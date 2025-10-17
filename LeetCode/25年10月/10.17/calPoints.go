package temp

import "strconv"

func calPoints(operations []string) int {
	n := len(operations)
	record := make([]int, 0, n)

	for _, v := range operations {
		switch v {
		case "+":
			score := record[len(record)-1] + record[len(record)-2]
			record = append(record, score)
		case "D":
			score := record[len(record)-1] * 2
			record = append(record, score)
		case "C":
			record = record[:len(record)-1]
		default:
			score, _ := strconv.ParseInt(v, 10, 64)
			record = append(record, int(score))
		}
	}

	ans := 0
	for _, v := range record {
		ans += v
	}
	return ans
}
