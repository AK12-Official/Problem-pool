long long mostPoints(int** questions, int questionsSize, int* questionsColSize) {
    // long long dp[questionsSize];
    // memset(dp,0,sizeof(dp));

    long long* dp = (long long*)malloc(questionsSize * sizeof(long long));
    memset(dp, 0, questionsSize * sizeof(long long));
    dp[questionsSize-1]=questions[questionsSize-1][0];


    for(int i=questionsSize-2;i>=0;i--){
        long long d0=0,skip=0;

        if(i+questions[i][1]+1>=questionsSize){
            d0=questions[i][0];
        }else{
            d0=dp[i+questions[i][1]+1]+questions[i][0];
        }
        skip=dp[i+1];

        dp[i]=d0>skip?d0:skip;
    }

    long long ans =dp[0];
    for(int i=0;i<questionsSize;i++){
        ans=ans>dp[i]?ans:dp[i];
    }
    return ans;
}

//首先是注意13行和16行的索引
//索引最后不+1的话 在13行处不加会导致越界 因为i+questions[i][1]可能刚好等于questionsSize+1，就导致16行的dp[i+questions[i][1]+1]越界
//在16行要+1 举个例子说明
//[[3,2],[4,3],[4,4],[2,5]]  计算dp[0]时 i=0  questions[0][1]=2  也就是说第3题是要跳过的 不+1的话就跳不过去


//然后是dp的状态转移方程  要把重点着眼在**状态**上  只关心状态 

//最后是注意dp的初始化和遍历方向 反向遍历要比正向简单的多