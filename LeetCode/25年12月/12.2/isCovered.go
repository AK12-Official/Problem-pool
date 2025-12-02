package temp

func isCovered(ranges [][]int, left int, right int) bool {
	rec := make([]int,52)

	for _,v :=range ranges{
		l:=v[0]
		r:=v[1]
		rec[l]++
		rec[r+1]--
	}

	for i := 0; i < 50; i++ {
		rec[i+1] = rec[i] + rec[i+1]
	}

	for i:=left;i<=right;i++{
		if rec[i] == 0{
			return false
		}
	}
	return true
}