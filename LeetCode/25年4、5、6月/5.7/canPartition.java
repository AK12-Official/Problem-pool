class Solution1 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        int[][] dp = new int[len + 1][sum / 2 + 1];

        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < sum / 2; i++) {
            dp[0][i] = 0;
        }

        // 迭代
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                // 装不下
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 能装下---不装or装
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return dp[len][sum / 2] == sum / 2;
    }
}