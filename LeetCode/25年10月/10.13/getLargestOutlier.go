package temp

func getLargestOutlier(nums []int) int {

	m := make(map[int]int)
	sum := 0
	for _, num := range nums {
		m[num]++
		sum += num
	}
	//记录 元素-出现次数 映射

	ans := -1001
	for k, v := range m {
		//移除某个元素
		sumCopy := sum - k
		v-- // 本地副本，表示移除一个 k 后剩余的 k 个数

		// 如果剩余和不是偶数，不可能存在等于 sumCopy/2 的整数元素
		if sumCopy%2 != 0 {
			continue
		}

		//得到新的key
		key := sumCopy / 2
		//如果新旧k相同 检查出现次数是否为1
		if key == k {
			//v==0则不是异常值
			if v != 0 {
				if k > ans {
					ans = k
				}
			}
		} else {
			if _, exist := m[key]; exist {
				if k > ans {
					ans = k
				}
			}
		}
	}
	return ans
}
