// 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

// 请返回 nums 的动态和。

// 示例 1：

// 输入：nums = [1,2,3,4]
// 输出：[1,3,6,10]
// 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* runningSum(int* nums, int numsSize, int* returnSize) {
    *returnSize=numsSize;
    for(int i=1;i<numsSize;i++)
    {
        nums[i]+=nums[i-1];
    }

    return nums;
}

//看评论区说是ez dp
 //不懂  *returnSize=numsSize; 是在干嘛

 //add 函数返回int*类型，所以returnSize是int*类型，*returnSize是int类型，是返回值，是数组的长度