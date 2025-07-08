// 给你一个整数数组 nums 和两个正整数 m 和 k 。

// 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。

// 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。

// 子数组指的是一个数组中一段连续 非空 的元素序列。
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "uthash.h"

typedef struct {
    int key;
    int value;
    UT_hash_handle hh;
} HashItem;

void addToHash(HashItem** hashTable, int key) {
    HashItem* item;
    HASH_FIND_INT(*hashTable, &key, item);
    if (item == NULL) {
        item = (HashItem*)malloc(sizeof(HashItem));
        item->key = key;
        item->value = 1;
        HASH_ADD_INT(*hashTable, key, item);
    } else {
        item->value++;
    }
}

void removeFromHash(HashItem** hashTable, int key) {
    HashItem* item;
    HASH_FIND_INT(*hashTable, &key, item);
    if (item != NULL) {
        if (item->value == 1) {
            HASH_DEL(*hashTable, item);
            free(item);
        } else {
            item->value--;
        }
    }
}

int getUniqueCount(HashItem* hashTable) {
    int count = 0;
    HashItem* item;
    for (item = hashTable; item != NULL; item = item->hh.next) {
        count++;
    }
    return count;
}

long long maxSum(int* nums, int numsSize, int m, int k) {
    long long maxSum = 0;
    long long currentSum = 0;
    HashItem* hashTable = NULL;

    for (int i = 0; i < numsSize; i++) {
        if (i >= k) {
            currentSum -= nums[i - k];
            removeFromHash(&hashTable, nums[i - k]);
        }

        currentSum += nums[i];
        addToHash(&hashTable, nums[i]);

        if (i >= k - 1 && getUniqueCount(hashTable) >= m) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
    }

    // 释放哈希表
    HashItem* currentItem;
    HashItem* tmp;
    HASH_ITER(hh, hashTable, currentItem, tmp) {
        HASH_DEL(hashTable, currentItem);
        free(currentItem);
    }

    return maxSum;
}

int main() {
    int nums[] = {1, 2, 1, 2, 3};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int m = 2;
    int k = 3;
    long long result = maxSum(nums, numsSize, m, k);
    printf("最大和: %lld\n", result); // 输出: 最大和: 6
    return 0;
}

//我承认这个哈希操作很 可
//但是C这个也太复杂了
//考虑用Java实现