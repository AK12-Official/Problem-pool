// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

// 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

// 你可以按任意顺序返回答案。


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdio.h>
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    
    for(int i=0;i<numsSize;i++)
    {
        for(int j=i+1;j<numsSize;j++)
        {
            if((i!=j)&&(nums[i]+nums[j]==target))
            {
                int* ret = malloc(sizeof(int) * 2);
                *returnSize=2;
                ret[0] = i, ret[1] = j;
                return ret;
            }
        }
    }
    *returnSize=0;
    return NULL;
}
 