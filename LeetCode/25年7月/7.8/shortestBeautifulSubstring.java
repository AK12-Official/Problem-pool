//2904
class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        if (s.replace("0", "").length() < k) {
            return "";
        }

        char[] S = s.toCharArray();
        String ans = s;
        int cnt1 = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            cnt1 += S[right] - '0';
            while (cnt1 > k || S[left] == '0') {
                cnt1 -= S[left++] - '0';
            }
            if (cnt1 == k) {
                String t = s.substring(left, right + 1);
                if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}
