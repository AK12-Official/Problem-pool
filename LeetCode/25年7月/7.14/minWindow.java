
import java.util.HashMap;
import java.util.Map;

class Solution {

    public String minWindow(String s, String t) {
        // 创建字符频次映射
        Map<Character, Integer> map = new HashMap<>();

        // 遍历字符串，统计每个字符的出现次数
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] S = s.toCharArray();
        int left = 0, right = 0;
        int len = S.length + 1;
        int beginIndex = 0, endIndex = -1;
        for (right = 0; right < s.length(); right++) {
            if (map.containsKey(S[right])) {
                map.put(S[right], map.get(S[right]) - 1);
            }
            while (allBelowZero(map)) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    beginIndex = left;
                    endIndex = right;
                }
                if (map.containsKey(S[left])) {
                    map.put(S[left], map.get(S[left]) + 1);
                }
                left++;
            }

        }
        if (endIndex == -1) {
            return ""; // 没有找到覆盖子串
        }
        return s.substring(beginIndex, endIndex + 1);
    }

    private boolean allBelowZero(Map<Character, Integer> map) {
        for (int val : map.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        Solution sln = new Solution();
        System.out.println(sln.minWindow(s, t));
        System.out.println("finish");
    }
}
