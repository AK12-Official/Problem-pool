
import java.util.ArrayList;

class Solution {

    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        long total = (long) n * (n + 1) / 2;
        if (total < k) {
            return -1;
        }

        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countActive(s, order, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private long countActive(String s, int[] order, int t) {
        int n = s.length();
        boolean[] isStar = new boolean[n];
        for (int i = 0; i <= t; i++) {
            isStar[order[i]] = true;
        }
        long inactive = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (!isStar[i]) {
                len++;
            } else {
                inactive += (long) len * (len + 1) / 2;
                len = 0;
            }
        }
        if (len > 0) {
            inactive += (long) len * (len + 1) / 2;
        }
        long total = (long) n * (n + 1) / 2;
        return total - inactive;
    }
}
//逆向思维是对的

