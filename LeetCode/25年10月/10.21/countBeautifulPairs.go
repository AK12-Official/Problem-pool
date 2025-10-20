package temp

func countBeautifulPairs(nums []int) int {
	ans := 0
	record := new([9]int)

	for _, v := range nums {
		f := getFirst(v)
		v = v % 10
		for i := 0; i < 9; i++ {
			if record[i] != 0 && gcd(v, i+1) == 1 {
				ans += record[i]
			}
		}
		record[f-1]++
	}
	return ans
}

func gcd(x, y int) int {
	if y == 0 {
		return x
	}
	return gcd(y, x%y)
}

func getFirst(num int) int {
	for num >= 10 {
		num /= 10
	}
	return num
}

//last   first
//1			all
//2			1 3 5 7 9
//3			1 2 4 5 7 8
//4			1 3 5 7 9
//5			1 2 3 4 6 7 8 9
//6   		1 5 7 8 9
//
