
import java.util.HashMap;
import java.util.Map;

class Solution {

    public long validSubstringCount(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();

        char[] word = word2.toCharArray();
        for (char c : word) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = word.length;

        word = word1.toCharArray();

        int left = 0, right;
        long ans = 0;

        for (right = 0; right < word.length; right++) {
            if (map.containsKey(word[right])) {
                if (map.get(word[right]) > 0) {
                    count--;
                }
                map.put(word[right], map.get(word[right]) - 1);
            }
            while (count <= 0) {
                if (map.containsKey(word[left])) {
                    map.put(word[left], map.get(word[left]) + 1);
                    if (map.get(word[left]) > 0) {
                        count++;
                    }
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }

    public long validSubstringCount_Better(String S, String T) {
        if (S.length() < T.length()) {
            return 0;
        }

        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[] diff = new int[26]; // t 的字母出现次数与 s 的字母出现次数之差
        for (char c : t) {
            diff[c - 'a']++;
        }

        // 统计窗口内有多少个字母的出现次数比 t 的少
        int less = 0;
        for (int d : diff) {
            if (d > 0) {
                less++;
            }
        }

        long ans = 0;
        int left = 0;
        for (char c : s) {
            diff[c - 'a']--;
            if (diff[c - 'a'] == 0) {
                // c 移入窗口后，窗口内 c 的出现次数和 t 的一样
                less--;
            }
            while (less == 0) { // 窗口符合要求
                char outChar = s[left++]; // 准备移出窗口的字母
                if (diff[outChar - 'a'] == 0) {
                    // outChar 移出窗口之前检查出现次数，
                    // 如果窗口内 outChar 的出现次数和 t 的一样，
                    // 那么 outChar 移出窗口后，窗口内 outChar 的出现次数比 t 的少
                    less++;
                }
                diff[outChar - 'a']++;
            }
            ans += left;
        }
        return ans;
    }
}

    
// diff这个思路也太天才了

