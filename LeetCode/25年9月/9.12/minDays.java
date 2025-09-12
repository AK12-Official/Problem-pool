
class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m * k > n) {
            return -1;
        }

        int left = 0;
        int right = bloomDay[0];
        for (int i = 1; i < n; i++) {
            right = Math.max(bloomDay[i], right);
        }
        int mid;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (check(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private boolean check(int[] bloomDay, int m, int k, int days) {
        int n = bloomDay.length;
        boolean[] isBloom = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= days) {
                isBloom[i] = true;
            }
        }
        int bouquets = 0;
        for (int i = 0; i < n;) {
            int count = 0;

            while (i < n && isBloom[i] && count < k) {
                count++;
                i++;
            }
            if (count == k) {
                bouquets++;
            } else {
                i = i - count + 1;
            }
            if (bouquets >= m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] bloomDay = new int[]{1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.err.println(new Solution().minDays(bloomDay, m, k) + "");
    }
}
