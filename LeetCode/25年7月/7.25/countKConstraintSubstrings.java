
class Solution {

    public int countKConstraintSubstrings(String s, int k) {
        char[] S = s.toCharArray();

        int count0 = 0, count1 = 0;

        int left = 0;
        int ans = 0;
        for (int right = 0; right < S.length; right++) {
            if (S[right] == '1') {
                count1++;
            } else {
                count0++;
            }

            while (count1 > k && count0 > k) {
                if (S[left] == '1') {
                    count1--;
                } else {
                    count0--;
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public int countKConstraintSubstringsPRO(String s, int k) {
        char[] S = s.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < S.length; i++) {
            cnt[S[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[S[left] & 1]--;
                left++;
            }
            ans += i - left + 1;
        }
        return ans;

    }
}
// if 的处理太耗时间了