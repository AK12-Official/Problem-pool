int deleteAndEarn(int* nums, int numsSize) {

    if(numsSize==0) return 0;
    if(numsSize==1) return nums[0];
 
    int max=0;
    for(int i=0;i<numsSize;i++){
        if(nums[i]>max) max=nums[i];
    }
    int *dp=(int *)malloc(sizeof(int)*(max+1));
    memset(dp,0,sizeof(int)*(max+1));
    for(int i=0;i<numsSize;i++){
        dp[nums[i]]+=nums[i];
    }
    int *dp2=(int *)malloc(sizeof(int)*(max+1));
    dp2[0]=0;
    dp2[1]=dp[1];
    for(int i=2;i<=max;i++){
        dp2[i]=dp2[i-1]>dp2[i-2]+dp[i]?dp2[i-1]:dp2[i-2]+dp[i];
    }
    return dp2[max];


    //实践发现不能简单的把数组排序后当成打家劫舍处理
    //因为对于[3，1]这种数组吧，数组元素并不连续
    //但是排完序之后 数组元素就在内存空间中物理相邻连续了
    // 按打家劫舍处理就会导致打劫不连续
    //按正确的方法应当把数组元素的值当成下标，然后对应的值当成打家劫舍的值
    //也就是在中间插入0将其转换为打家劫舍问题
    //就是说 数组中元素的值其实是房屋的编号，房屋的价值则由求和确定
}