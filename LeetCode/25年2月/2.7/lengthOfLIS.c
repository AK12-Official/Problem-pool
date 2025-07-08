int lengthOfLIS(int* nums, int numsSize) {
    if(numsSize==0)return 0;
    if(numsSize==1)return 1;
    int dp[numsSize]={};

    
    for(int i=0;i<numsSize;i++){
        dp[i]=1;
        for(int j=0;j<i;j++){
            if(nums[j]<nums[i])
                dp[i]=fmax(dp[i],dp[j]+1);
        }
        
    }
    int ans=dp[0];
    for(int i=1;i<numsSize;i++){
        ans=ans>dp[i]?ans:dp[i];
    }
    return ans;
}