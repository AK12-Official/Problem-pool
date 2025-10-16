
class Solution {

    public int splitArray(int[] nums, int k) {
        int len = nums.length;

        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < len; i++) {
            left = Math.min(left, nums[i]);
            right += nums[i];   //这里要是不溢出我当场吃
        }

        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mid) {
        int record = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return false;
            }
            temp += nums[i];
            if (temp > mid) {
                i--;
                temp = 0;
                record++;
            }
        }
        if (temp > 0) {
            record++;
        }
        return record <= k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 4};
        int k = 3;
        System.err.println(new Solution().splitArray(nums, k) + "   123");
    }
}
