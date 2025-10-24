package temp

func findAnagrams(s string, p string) []int {
	n := len(s)
	m := len(p)

	if m > n {
		return []int{}
	}

	record := make(map[byte]int)
	for i := 0; i < m; i++ {
		record[p[i]]++
	}

	windowCount := make(map[byte]int)
	ans := make([]int, 0, n)

	for right := 0; right < n; right++ {
		// 扩展窗口:添加右边字符
		windowCount[s[right]]++

		// 收缩窗口:保持窗口大小为 m
		if right >= m {
			leftChar := s[right-m]
			windowCount[leftChar]--
			if windowCount[leftChar] == 0 {
				delete(windowCount, leftChar)
			}
		}

		// 检查窗口是否匹配
		if right >= m-1 && isAnagram(record, windowCount) {
			ans = append(ans, right-m+1)
		}
	}

	return ans
}

func isAnagram(a, b map[byte]int) bool {
	if len(a) != len(b) {
		return false
	}
	for k, v := range a {
		if b[k] != v {
			return false
		}
	}
	return true
}
