package temp

func numberOfBoomerangs(points [][]int) (ans int) {
	n := len(points)
	for i := 0; i < n; i++ {
		m := make(map[int]int)
		for j := 0; j < n; j++ {
			if j == i {
				continue
			}
			key := dis(points[i], points[j])
			m[key]++
			ans += 2*m[key] - 2
		}
		// for _,value :=range m{
		// 	ans+=value*(value-1)
		// }
	}
	return
}

// value	1	2	3	4
// cnt		0	2	6	12

func dis(i1, i2 []int) int {
	dx := i1[0] - i2[0]
	dy := i1[1] - i2[1]
	return dx*dx + dy*dy
}
func abs(i int) int {
	if i > 0 {
		return i
	}
	return -i
}
