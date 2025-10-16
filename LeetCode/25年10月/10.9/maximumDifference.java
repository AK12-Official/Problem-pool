
class Solution {

    public int maximumDifference(int[] nums) {
        int len = nums.length;

        int ans = -1;
        int preMin = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > preMin) {
                ans = nums[i] - preMin > ans ? nums[i] - preMin : ans;
            } else {
                preMin = nums[i];
            }
        }
        return ans;
    }
}
