#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int longestSubarray(int *nums, int numsSize)
{
    int ZeroCount = 0;
    int left = 0, right = 0;
    int ans = 0;

    //把该问题转化成了
    // 求一个子数组 里面最多有一个0
    for(right=0;right<numsSize;right++){
        if(nums[right]==0){
            ZeroCount++;
        }
        while(ZeroCount>1){
            if(nums[left]==0){
                ZeroCount--;
            }
            left++;
        }
        //这里不加1就实现了子数组里面最多有一个0（对于全一数字刚好得到numsSize-1）
        ans=ans>right-left?ans:right-left;
    }
    return ans;
}

int main()
{
    int nums[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    int numsSize = 9;
    printf("%d\n", longestSubarray(nums, numsSize));
    return 0;
}