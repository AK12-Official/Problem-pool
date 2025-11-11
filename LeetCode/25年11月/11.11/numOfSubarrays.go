package temp

func numOfSubarrays(arr []int) int {
	preSum := 0
	odd := 0  //奇数
	even := 1 //偶数

	ans := 0
	for _, v := range arr {
		preSum += v
		if preSum&1 == 1 {
			ans += even
			odd++
		} else {
			ans += odd
			even++
		}
	}

	return ans
}
