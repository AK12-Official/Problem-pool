int maxProfit(int* prices, int pricesSize, int fee) {
    //  持有 0              
    //  不持有 1  
    //  卖出算手续费
    int dp[pricesSize][2];
    memset(dp,0,sizeof(dp));

    dp[0][0]=-prices[0];
    dp[0][1]=0;

    for(int i=1;i<pricesSize;i++){
        //持有：当天买入/昨天持有
        dp[i][0]=fmax(dp[i-1][1]-prices[i],dp[i-1][0]);
        //不持有：今天卖出/昨天不持有
        dp[i][1]=fmax(dp[i-1][0]+prices[i]-fee,dp[i-1][1]);
    }
    return dp[pricesSize-1][1];
}