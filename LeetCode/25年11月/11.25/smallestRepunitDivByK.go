package temp

func smallestRepunitDivByK(k int) int {

	if k&1 == 0 {
		return -1
	}

	remainder := 0
	len := 0

	for len <= k {
		remainder = (remainder*(10%k) + 1) % k
		len++
		if remainder == 0 {
			return len
		}
	}
	return -1
}
