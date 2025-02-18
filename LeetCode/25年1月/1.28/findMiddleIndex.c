
// 给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。

// 中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。

// 如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。

// 请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。

#include <stdio.h>

int findMiddleIndex(int* nums, int numsSize) {
    int totalSum = 0;
    int leftSum = 0;

    // 计算数组的总和
    for (int i = 0; i < numsSize; i++) {
        totalSum += nums[i];
    }

    // 遍历数组，计算左边和右边的和
    for (int i = 0; i < numsSize; i++) {
        // 右边的和等于总和减去当前元素和左边的和
        int rightSum = totalSum - leftSum - nums[i];

        // 如果左边的和等于右边的和，返回当前索引
        if (leftSum == rightSum) {
            return i;
        }

        // 更新左边的和
        leftSum += nums[i];
    }

    // 如果没有找到满足条件的中间位置，返回-1
    return -1;
}

//我考虑用sum-left==sum-right来判断
//似乎效率很低（）

int main() {
    int nums[] = {2, 3, -1, 8, 4};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int result = findMiddleIndex(nums, numsSize);
    printf("Middle Index: %d\n", result);
    return 0;
}