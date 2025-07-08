int longestPalindromeSubseq(char* s) {
    int n=strlen(s);

    int dp[n][n];
    memset(dp, 0, sizeof(dp));

    for(int i=0;i<n;i++){
        dp[i][i]=1;
    }
    
    for(int i=n-1;i>=0;i--){
        for(int j=i+1;j<n;j++){
            if(s[i]==s[j]){
                dp[i][j]=dp[i+1][j-1]+2;
            }else{
                dp[i][j]=dp[i+1][j]>dp[i][j-1]?dp[i+1][j]:dp[i][j-1];
            }
        }
    }
    return dp[0][n-1];

    //长字符串的状态是由短字符串的状态推导出来的
    //所以要从短字符串开始推导
    //所以要从后往前推导
    //这么做似乎省下了之前用的int len=2;len<=n;len++的方法




}