int maxUncrossedLines(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int dp[nums1Size+1][nums2Size+1];
    memset(dp,0,sizeof(dp));

    for(int i=1;i<=nums1Size;i++){
        for(int j=1;j<=nums2Size;j++){
            if(nums2[j-1]==nums1[i-1]){
                dp[i][j]=dp[i-1][j-1]+1;
            }else{
                dp[i][j]=fmax(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    return dp[nums1Size][nums2Size];
}

//捏麻麻的 LIS套皮