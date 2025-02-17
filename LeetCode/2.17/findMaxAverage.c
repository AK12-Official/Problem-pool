double findMaxAverage(int* nums, int numsSize, int k) {
    int num=0;

    for(int i=0;i<k;i++){
        num+=nums[i];
    }
    double ans=num;
    for(int i=0;i<numsSize-k;i++){
        num=num-nums[i]+nums[i+k];
        ans=ans>num?ans:num;
    }
    double ret=ans/k;
    return ret;
}