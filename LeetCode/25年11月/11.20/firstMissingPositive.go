package temp

// func firstMissingPositive(nums []int) int {

// 	n := len(nums)

// 	for i := 0; i < n; i++ {
// 		if nums[i] <= 0 {
// 			nums[i] = n + 1
// 		}
// 	}

// 	for _, v := range nums {
// 		iv := abs(v)
// 		if iv >= 1 && iv <= n {
// 			idx := iv - 1
// 			nums[idx] = -abs(nums[idx])
// 		}
// 	}

// 	for i, v := range nums {
// 		if v > 0 {
// 			return i + 1
// 		}
// 	}
// 	return n + 1
// }

//	func abs(i int) int {
//		if i > 0 {
//			return i
//		}
//		return -i
//	}
func firstMissingPositive(nums []int) int {
	mp := make(map[int]int)
	n := len(nums)

	for _, v := range nums {
		if v < 0 || v > (n+1) {
			continue
		}
		mp[v]++
	}

	for i := 1; i <= n; i++ {
		if _, ok := mp[i]; !ok {
			return i
		}
	}
	return n + 1
}
