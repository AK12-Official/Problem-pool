package temp

func convert(s string, numRows int) string {

	if numRows == 1 {
		return s
	}

	len := len(s)
	record := make([]int, 0, len)

	line := 1
	grow := true
	for i := 0; i < len; i++ {
		//记录行号 [1,numRows]
		record = append(record, line)

		//根据line的方向和值决定line是+是-
		if line == 1 && !grow || line == numRows && grow {
			grow = !grow
		}

		if grow {
			line++
		} else {
			line--
		}
	}
	// 根据 record 将字符分配到对应行
	rows := make([][]byte, numRows) // index = line-1
	for i := 0; i < len; i++ {
		r := record[i] - 1
		rows[r] = append(rows[r], s[i])
	}

	// 按行拼接结果
	var out []byte
	for i := 0; i < numRows; i++ {
		out = append(out, rows[i]...)
	}
	return string(out)
}
