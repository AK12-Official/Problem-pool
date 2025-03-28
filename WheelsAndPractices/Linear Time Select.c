// #include <stdio.h>

// int findKthLargest(int *nums, int numsSize, int k)
// {
//     // 先找一个元素进行分区 找到第x大
//     int left = 0;
//     int right = numsSize - 1;
//     while (left <= right)
//     {
//         if (left == right)
//             return nums[left];

//         // 选取第一个元素作为pivot
//         // int pivot = nums[left];
        
//         // 选取随机元素作为pivot
//         int pivotIndex = left + rand() % (right - left + 1);
//         int pivot = nums[pivotIndex];
//         nums[pivotIndex] = nums[left];
//         nums[left] = pivot;

//         // 分区
//         int i = left;
//         int j = right;
//         while (i < j)
//         {
//             while (i < j && nums[j] >= pivot) // 不加等号就超时 估计是形成环路了
//                 j--;
//             nums[i] = nums[j]; // 此时pivot在j处
//             while (i < j && nums[i] <= pivot)
//                 i++;
//             nums[j] = nums[i]; // 此时pivot在i处
//         }
//         nums[i] = pivot;

//         if (numsSize - i == k)
//             return nums[i];
//         else if (numsSize - i > k)
//             left = i + 1;
//         else
//         {
//             right = i - 1;
//             // k = k - (numsSize - i);
//             //不用减去numsSize - i，因为k是相对位置，不是绝对位置
//         }
//     }
//     return -1;
// }

// int main()
// {
//     int nums[] = {7, 6, 5, 4, 3, 2, 1};
//     int numsSize = 7;
//     int k = 2;
//     printf("%d\n", findKthLargest(nums, numsSize, k));
//     return 0;
// }


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// 交换两个元素
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// 插入排序（用于小数组）
void insertionSort(int arr[], int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// 找到中位数的中位数
int findMedianOfMedians(int arr[], int left, int right) {
    int n = right - left + 1;
    // 如果元素数量小于等于5，直接排序并返回中位数
    if (n <= 5) {
        insertionSort(arr, left, right);
        return arr[left + n / 2];
    }
    
    // 将数组分为每组5个元素，找到每组的中位数
    int numGroups = (n + 4) / 5; // 向上取整
    int medians[numGroups];
    for (int i = 0; i < numGroups; i++) {
        int groupLeft = left + i * 5;
        int groupRight = groupLeft + 4;
        if (groupRight > right) groupRight = right;
        
        insertionSort(arr, groupLeft, groupRight);
        medians[i] = arr[groupLeft + (groupRight - groupLeft) / 2];
    }
    
    // 递归找到中位数的中位数
    return findMedianOfMedians(medians, 0, numGroups - 1);
}

// 使用中位数的中位数作为基准进行分区
int partition(int arr[], int left, int right, int pivot) {
    // 找到基准值的位置并交换到最右边
    int i;
    for (i = left; i < right; i++) {
        if (arr[i] == pivot) {
            break;
        }
    }
    swap(&arr[i], &arr[right]);
    
    // 标准分区过程
    i = left - 1;
    for (int j = left; j <= right - 1; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[right]);
    return i + 1;
}

// 使用中位数的中位数算法的选择算法
int select(int arr[], int left, int right, int k) {
    if (left == right) {
        return arr[left];
    }
    
    // 找到中位数的中位数作为基准
    int pivot = findMedianOfMedians(arr, left, right);
    
    // 使用这个基准进行分区
    int pivotIndex = partition(arr, left, right, pivot);
    
    // 根据k的位置决定递归方向
    if (k == pivotIndex) {
        return arr[k];
    } else if (k < pivotIndex) {
        return select(arr, left, pivotIndex - 1, k);
    } else {
        return select(arr, pivotIndex + 1, right, k-pivotIndex-1);
    }
}

// 打印数组
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {3,2,1,5,6,4};
    int n = sizeof(arr) / sizeof(arr[0]);
    for(int k=1;k<=n;k++){
        printf("原始数组: ");
        printArray(arr, n);
        
        // 注意: 在select函数中k是基于0的索引
        int result = select(arr, 0, n - 1, k - 1);
        
        printf("第%d小的元素是: %d\n", k, result);
        
        // 验证结果
        insertionSort(arr, 0, n - 1);
        printf("排序后的数组: ");
        printArray(arr, n);
        printf("验证结果: 第%d小的元素确实是 %d\n", k, arr[k - 1]);
    }
    return 0;

}





// 老师你好
// 今天上课时您展示AI给出的线性时间选择的代码时指出AI在处理其中一侧的递归调用时存在问题(没有修正参数k)
// 课后我在力扣平台练习(找第k大的元素时),将算法转到非递归实现，发现在处理其中一侧的递归调用时，不需要修正参数k(修改反而会导致WA)
// 我也去让AI生成了类似的递归代码，同样存在您说的情况(未修正参数k)
// 但是我更进一步询问AI时，AI解释说k是全局索引 不需要在递归时调整
// 同时我自己做了一些测试，发现不修正参数k时，结果是正确的
// gdb看了半天也没想明白具体原因,还望老师解惑