class Solution2 {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }

        // 初始化
        int[][] dp = new int[len + 1][sum / 2 + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < sum / 2 + 1; i++) {
            dp[0][i] = 0;
        }

        // 迭代
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - 2 * dp[len][sum / 2];
    }
}