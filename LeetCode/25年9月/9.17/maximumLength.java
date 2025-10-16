
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maximumLength(String s) {
        char[] S = s.toCharArray();

        int left = -1;
        int right = S.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(S, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left == 0 ? -1 : left;
    }

    private boolean check(char[] S, int mid) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i + mid - 1 < S.length; i++) {
            String sub = new String(S, i, mid);
            if (sub.chars().allMatch(c -> c == sub.charAt(0))) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                if (map.get(sub) >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}

class SolutionPRO {

    public int maximumLength(String s) {
        char[] S = s.toCharArray();

        int left = 0;
        int right = S.length + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(S, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left == 0 ? -1 : left;
    }

    private boolean check(char[] S, int mid) {
        Map<Character, Integer> countMap = new HashMap<>();
        int i = 0, n = S.length;
        while (i < n) {
            int j = i;
            while (j < n && S[j] == S[i]) j++;
            int len = j - i;
            if (len >= mid) {
                int cnt = len - mid + 1;
                //在len中直接统计长为mid的子串个数
                countMap.put(S[i], countMap.getOrDefault(S[i], 0) + cnt);
                if (countMap.get(S[i]) >= 3) return true;
            }
            i = j;
        }
        return false;
    }
}
