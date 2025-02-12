// 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

// 算法的时间复杂度应该为 O(log (m+n)) 。

#include <stdio.h>
#include <limits.h>

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    if (nums1Size > nums2Size) {
        return findMedianSortedArrays(nums2, nums2Size, nums1, nums1Size);
    }
    
    int x = nums1Size;
    int y = nums2Size;
    int low = 0, high = x;
    
    while (low <= high) {
        int partitionX = (low + high) / 2;
        int partitionY = (x + y + 1) / 2 - partitionX;
        
        int maxX = (partitionX == 0) ? INT_MIN : nums1[partitionX - 1];
        int maxY = (partitionY == 0) ? INT_MIN : nums2[partitionY - 1];
        
        int minX = (partitionX == x) ? INT_MAX : nums1[partitionX];
        int minY = (partitionY == y) ? INT_MAX : nums2[partitionY];
        
        if (maxX <= minY && maxY <= minX) {
            if ((x + y) % 2 == 0) {
                return ((double)fmax(maxX, maxY) + fmin(minX, minY)) / 2;
            } else {
                return (double)fmax(maxX, maxY);
            }
        } else if (maxX > minY) {
            high = partitionX - 1;
        } else {
            low = partitionX + 1;
        }
    }
    
    return -1; // Should never reach here
}

// 思路
// 确保第一个数组长度不大于第二个数组：

// 如果 nums1 的长度大于 nums2，交换它们，以确保 nums1 是较短的数组。这是为了减少二分查找的范围，提高效率。
// 初始化二分查找的范围：

// low 和 high 分别初始化为 0 和 nums1 的长度。
// 进行二分查找：

// 在 low 小于等于 high 的条件下，进行循环。
// 计算 partitionX 和 partitionY，分别表示 nums1 和 nums2 的分割位置。partitionX 是 nums1 的中间位置，partitionY 是根据总长度和 partitionX 计算出来的。
// 获取分割位置的最大值和最小值：

// maxX 和 maxY 分别是 nums1 和 nums2 分割位置左侧的最大值。
// minX 和 minY 分别是 nums1 和 nums2 分割位置右侧的最小值。
// 如果分割位置在数组的边界上，使用 INT_MIN 或 INT_MAX 作为边界值。
// 检查是否找到正确的分割位置：

// 如果 maxX <= minY 且 maxY <= minX，说明找到了正确的分割位置。
// 如果两个数组的总长度是偶数，中位数是左侧最大值和右侧最小值的平均值。
// 如果总长度是奇数，中位数是左侧最大值。
// 调整二分查找的范围：

// 如果 maxX > minY，说明 partitionX 太大，需要向左移动，即 high = partitionX - 1。
// 如果 maxY > minX，说明 partitionX 太小，需要向右移动，即 low = partitionX + 1