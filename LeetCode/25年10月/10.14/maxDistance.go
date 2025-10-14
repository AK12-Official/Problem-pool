package temp

func maxDistance(arrays [][]int) int {
	ArrayLen := len(arrays)
	record := make([][]int, 0, ArrayLen)

	for _, array := range arrays {
		n := len(array)
		temp := [2]int{array[0], array[n-1]}
		record = append(record, temp[:])
	}

	preMin := record[0][0]
	preMax := record[0][1]
	ans := 0
	for i := 1; i < ArrayLen; i++ {
		if abs(record[i][1]-preMin) > ans {
			ans = abs(record[i][1] - preMin)
		}

		if abs(preMax-record[i][0]) > ans {
			ans = abs(preMax - record[i][0])
		}

		if record[i][0] < preMin {
			preMin = record[i][0]
		}
		if record[i][1] > preMax {
			preMax = record[i][1]
		}
	}

	return ans
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func maxDistancePro(arrays [][]int) int {
	preMin := arrays[0][0]
	preMax := arrays[0][len(arrays[0])-1]

	arraysLen := len(arrays)

	var ans int = 0
	for i := 1; i < arraysLen; i++ {
		array := arrays[i]
		n := len(array)
		curr := array[n-1]

		if abs(preMax-array[0]) > ans {
			ans = abs(preMax - array[0])
		}

		if abs(curr-preMin) > ans {
			ans = abs(curr - preMin)
		}

		if curr > preMax {
			preMax = curr
		}
		if array[0] < preMin {
			preMin = array[0]
		}
	}

	return ans
}
