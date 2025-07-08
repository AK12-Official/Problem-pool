class Solution4 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) % 2 != 0 || sum < target || target < -sum) {
            return 0;
        }
        int s = (sum + target) / 2; // 背包大小

        int[][] dp = new int[nums.length + 1][s + 1];
        // 初始化
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1; // 背包大小为0时，只有一种选择，即不选任何物品
        }

        // 迭代
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= s; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j]; // 装不下
                }

            }
        }

        return dp[nums.length][s]; // 返回背包大小为s时的选择数
    }
}

class Main1 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] nums = { 100 };
        int target = -200;
        System.out.println(solution.findTargetSumWays(nums, target)); // 输出5
    }
}