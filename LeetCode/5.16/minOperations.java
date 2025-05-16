class Solution {
    public int minOperations(int[] nums, int x) {
        // 计算数组总和
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        // 目标和为 total - x，即寻找最长的子数组和为 total - x
        int target = total - x;
        if (target < 0) return -1;  // 如果目标和为负，说明无解
        if (target == 0) return nums.length;  // 如果目标和为0，需要使用所有元素
        
        int maxLen = -1;
        int sum = 0;
        int left = 0;
        
        // 使用滑动窗口寻找最长的子数组和为 target
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }
            
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}