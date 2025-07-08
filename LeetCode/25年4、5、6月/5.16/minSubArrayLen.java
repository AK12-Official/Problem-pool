class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target)
            return 0;

        int ret = nums.length;
        int left = 0, right = 0;
        sum = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (sum >= target && left <= right) {
                sum -= nums[left];
                ret = Math.min(ret, right - left + 1);
                left++;
                sum -= nums[right];
                right--;
            }
        }

        return ret;
    }
}