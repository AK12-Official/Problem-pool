package temp

func subarraysDivByK(nums []int, k int) int {
	preSum := 0
	m := make(map[int]int)
	m[0] = 1

	ans := 0
	for _, v := range nums {
		preSum += v
		rem := ((preSum % k) + k) % k
		//再次模k是为了处理presum%k>0的情况
		//不能直接使用绝对值
		//比如 -1%5=-1 （在GoLang中）
		//实际上我们想要他返回4而不是abs(-1)
		ans += m[rem]
		m[rem]++
	}
	return ans
}
