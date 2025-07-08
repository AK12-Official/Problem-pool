int longestArithSeqLength(int *nums, int numsSize)
{
    int dp[numsSize][1000];

    for (int i = 0; i < numsSize; i++)
    {
        int d = 0;
        for (int j = 0; j < 1000; j++)
        {
            dp[i][j] = 1;
        }
        for (int j = 0; j < i; j++)
        {
            d = nums[i] - nums[j] + 500;
            dp[i][d] = fmax(dp[j][d] + 1, dp[i][d]);
        }
    }

    int ans = dp[0][0];
    for (int i = 0; i < numsSize; i++)
    {
        for (int j = 0; j < 1000; j++)
        {
            ans = ans > dp[i][j] ? ans : dp[i][j];
        }
    }
    return ans;
}