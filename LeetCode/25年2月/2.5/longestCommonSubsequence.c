int longestCommonSubsequence(char* text1, char* text2) {
    int n1=strlen(text1);
    int n2=strlen(text2);
    // if(n2>n1) return longestCommonSubsequence(text2,text1);

    int dp[n1+1][n2+1];
    memset(dp,0,sizeof(dp));


    // for(int i=n1-1;i>=0;i--){
    //     for(int j=i;j<n1;j++){
    //         for(int k=n2-1;)
    //     }
    // }
    for(int i=0;i<n1;i++){
        dp[i][0]=0;
    }
    for(int i=0;i<n2;i++){
        dp[0][i]=0;
    }
    for(int i=1;i<=n1;i++){
        for(int j=1;j<=n2;j++){
            
            if(text1[i-1]==text2[j-1])
            {
                dp[i][j]=dp[i-1][j-1]+1;
            }else{
                dp[i][j]=fmax(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    return dp[n1][n2];
}

//dp[i][j]表示text1[0:i]和text2[0:j]的最长公共子序列长度（text1的前i个和text2的前j个字符）
//dp[i][j]=dp[i-1][j-1]+1 if text1[i]==text2[j]
//dp[i][j]=max(dp[i-1][j],dp[i][j-1]) if text1[i]!=text2[j]
//初始化dp[i][0]=0,dp[0][j]=0
//dp[i][j] 表示 text1 的前 i 个字符和 text2 的前 j 个字符的最长公共子序列的长度。
//返回dp[n1][n2]即可
//注意循环的边界条件