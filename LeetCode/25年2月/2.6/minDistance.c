int minDistance(char* word1, char* word2) {
    int n1=strlen(word1);
    int n2=strlen(word2);

    int fmin(int a,int b,int c){
        int min=a;
        min=min<b?min:b;
        min=min<c?min:c;
        return min;
    }

    int dp[n1+1][n2+1];
    memset(dp,0,sizeof(dp));

    for(int i=0;i<n1+1;i++){
        dp[i][0]=i;
    }
    for(int j=0;j<n2+1;j++){
        dp[0][j]=j;
    }

    for(int i=1;i<n1+1;i++){
        for(int j=1;j<n2+1;j++){
            if(word1[i-1]==word2[j-1])
            {
                dp[i][j]=fmin(dp[i-1][j-1]-1,dp[i-1][j],dp[i][j-1])+1;
            }else{
                dp[i][j]=fmin(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
            }
        }
    }

    return dp[n1][n2];
}