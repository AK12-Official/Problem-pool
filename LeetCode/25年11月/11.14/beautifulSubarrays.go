package temp

func beautifulSubarrays(nums []int) (ans int64) {
	preXOR := 0

	mp := make(map[int]int)
	mp[0] = 1

	for _, v := range nums {
		preXOR ^= v

		if value, ok := mp[preXOR]; ok {
			ans += int64(value)
		}

		mp[preXOR]++
	}

	return
	//翻译成人话就是 一个子数组 分前后两部分 和相同
}

//我说异或太伟大了有没有懂的
//子数组 l..r 的异或等于 preXOR_r ^ preXOR_{l-1}。当 preXOR_r == preXOR_{l-1} 时，该子数组异或为 0（或前后两部分相同）。
//我们遍历到下标 i 时，用 mp[preXOR_i] 累加此前出现相同前缀异或的次数（这些 j 满足 preXOR_j == preXOR_i，且子数组 j+1..i 的异或为 0）。
//若不把空前缀计入（mp[0]=1），当某个前缀本身 preXOR_i == 0（即从数组开头到 i 的子数组异或为 0）时就不会被计入答案。
//因此初始化 mp[0]=1 等价于把 j = -1（空前缀）当成一个已出现的前缀，从而正确统计以索引 0 开始且异或为 0 的子数组。
//举例：nums=[1,1]，遍历到 i=1 时 preXOR=0，mp[0]=1 使得 ans += 1，正确计入子数组 [0..1]。/
