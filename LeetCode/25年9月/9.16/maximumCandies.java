
class Solution {

    public int maximumCandies(int[] candies, long k) {
        int right = candies[0];
        for (int i = 1; i < candies.length; i++) {
            right = Math.max(right, candies[i]);
        }
        int left = 0;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(candies, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] candies, long k, int mid) {
        long record = 0;
        for (int i = 0; i < candies.length; i++) {
            record += candies[i] / mid;

            if (record >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{9, 10, 1, 2, 10, 9, 9, 10, 2, 2};
        int k = 3;
        System.out.println(new Solution().maximumCandies(candies, k) + "   done");
    }
}
