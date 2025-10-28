package temp

func numberOfRightTriangles(grid [][]int) int64 {
	row := len(grid)
	if row == 0 {
		return 0
	}
	col := len(grid[0])

	rowCnt := make([]int, row)
	colCnt := make([]int, col)

	for i := 0; i < row; i++ {
		rowCnt[i] = sum(grid[i])
	}

	for j := 0; j < col; j++ {
		s := 0
		for i := 0; i < row; i++ {
			s += grid[i][j]
		}
		colCnt[j] = s
	}

	var ans int64
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if grid[i][j] == 1 {
				ans += int64((rowCnt[i] - 1) * (colCnt[j] - 1))
			}
		}
	}
	return ans
}

func sum(nums []int) int {
	s := 0
	for _, v := range nums {
		s += v
	}
	return s
}
