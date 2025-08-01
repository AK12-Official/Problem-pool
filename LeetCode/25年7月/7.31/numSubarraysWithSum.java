
class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return AtMost(nums, goal) - AtMost(nums, goal - 1);
    }

    int AtMost(int[] nums, int goal) {
        int left = 0;
        int ans = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
        }

        return ans;
    }
}
