#include <stdio.h>
#include <math.h>

int findNumberOfLIS(int *nums, int numsSize)
{
    int dp[numsSize], count[numsSize];
    for (int i = 0; i < numsSize; i++)
    {
        dp[i] = 1;
        count[i] = 1;
    }
    int max = 1;
    for (int i = 1; i < numsSize; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (nums[i] > nums[j])
            {
                if (dp[j] + 1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if (dp[j] + 1 == dp[i])
                {
                    count[i] += count[j];
                }
            }
        }
        max = fmax(max, dp[i]);
    }
    int result = 0;
    for (int i = 0; i < numsSize; i++)
    {
        if (dp[i] == max)
        {
            result += count[i];
        }
    }
    return result;
}
int main()
{
    int nums[] = {1,3,2};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int result = findNumberOfLIS(nums, numsSize);
    printf("Number of Longest Increasing Subsequences: %d\n", result);
    return 0;
}

//太惦记在300题基础上用数组字典进行记录了
//还是DP 继承了300题的思路
//用count数组记录在i位置和结尾的递增子序列个数

//count[i]=count[j]   找到了更长的递增子序列 在i结尾的序列数就等于在j结尾的序列数
//count[i]+=count[j]  找到了相同长度的递增子序列 在i结尾的序列数就等于在i结尾的序列数加上j结尾的序列数
//这里的在i结尾的序列数其实就是在上一行的j处结尾的序列数
//因为 line19 的if一定先执行 先进行了状态转移

//总的来说其实就是 
//count[i]等于其对应的dp[i]的值减一得到的值的对应的索引(j)处的count[j]的和 这个j在i之前 可能有多个