package temp

import "math/bits"

func countPalindromicSubsequence(s string) (ans int) {

	suf := make(map[rune]int)
	for _, x := range s {
		suf[x]++
	}

	record := make(map[string]int)
	pre := make(map[rune]int)
	for _, x := range s {
		suf[x]--

		for k := range pre {
			if v, ok := suf[k]; ok && v > 0 {
				str := string([]rune{k, x, k})
				if _, ok := record[str]; !ok {
					ans++
					record[str]++
				}
			}
		}
		pre[x]++
	}

	return
}

func countPalindromicSubsequencePRO(s string) (ans int) {
	var pre, suf, has [26]int
	for _, ch := range s[1:] {
		suf[ch-'a']++
	}
	for i := 1; i < len(s)-1; i++ { // 枚举回文子序列的中间字符
		pre[s[i-1]-'a']++
		suf[s[i]-'a']--
		for j := 0; j < 26; j++ { // 枚举中间字符的左右字符
			if pre[j] > 0 && suf[j] > 0 { // 找到了一个回文子序列
				has[s[i]-'a'] |= 1 << j
				//天才！ 利用int的32位以位图的形式存储回文串的中间字符 天才！nb
			}
		}
	}
	for _, mask := range has {
		ans += bits.OnesCount(uint(mask)) // 累加二进制中 1 的个数即为答案
	}
	return
}
