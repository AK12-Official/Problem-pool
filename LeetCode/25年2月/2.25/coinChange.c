int coinChange(int *coins, int coinsSize, int amount)
{

    int *dp = (int *)malloc(sizeof(int) * (amount + 1));
    memset(dp, 0x3f, sizeof(int) * (amount + 1));

    dp[0] = 0;

    // for(int i=1;i<=amount;i++){
    //     for(int j=0;j<coinsSize;j++){
    //         if(i==coins[j]){
    //             dp[i]=1;
    //         }
    //     }
    // }

    for (int i = 1; i <= amount; i++)
    {
        for (int j = 0; j < coinsSize; j++)
        {
            if (i >= coins[j])
            {
                dp[i] = dp[i] < dp[i - coins[j]] + 1 ? dp[i] : dp[i - coins[j]] + 1;
            }
        }
    }

    // int temp;
    // for(int i=1;i<=amount;i++){
    //     if(dp[i]!=1){
    //         for(int j=0;j<coinsSize;j++){
    //             if(i-coins[j]>0&&dp[i-coins[j]]==1){
    //                 dp[i]++;
    //             }
    //         }
    //     }
    // }

    // return dp[amount];

    int result = dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
}



// memset(dp, 0x3f, sizeof(int) * (amount + 1)) 
// 这行代码将 dp 数组的每个字节都设置为 0x3f。
// 由于 dp 数组是 int 类型的数组，每个元素占用 4 个字节，因此每个 int 元素的值将被设置为 0x3f3f3f3f。

//状态转移的抽象思路是比较容易得到的 就是具体的实现细节需要注意