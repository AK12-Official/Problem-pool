
class Solution {

    public int numberOfSubstrings(String s) {
        int[] record = new int[]{0, 0, 0};
        int flag = 3;

        int left = 0, right = 0;
        int ans = 0;
        char[] S = s.toCharArray();
        for (right = 0; right < S.length; right++) {
            if (record[S[right] - 'a'] == 0) {
                flag--;
            }

            record[S[right] - 'a']++;

            while (flag == 0) {
                record[S[left] - 'a']--;
                if (record[S[left] - 'a'] == 0) {
                    flag++;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
