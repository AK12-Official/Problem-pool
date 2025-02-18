// 给你一个整数数组 nums 和两个正整数 m 和 k 。

// 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。

// 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。

// 子数组指的是一个数组中一段连续 非空 的元素序列。

long long maxSum(int* nums, int numsSize, int m, int k) {
    if (numsSize < k) return 0;

    long long maxSum = 0;
    long long currentSum = 0;
    int distinctCount = 0;
    int freq[100001] = {0}; // 假设 nums 中的元素范围在 0 到 100000 之间

    for (int i = 0; i < k; i++) {
        currentSum += nums[i];
        if (freq[nums[i]] == 0) distinctCount++;
        freq[nums[i]]++;
    }

    if (distinctCount >= m) maxSum = currentSum;

    for (int i = k; i < numsSize; i++) {
        currentSum += nums[i];
        if (freq[nums[i]] == 0) distinctCount++;
        freq[nums[i]]++;

        currentSum -= nums[i - k];
        freq[nums[i - k]]--;
        if (freq[nums[i - k]] == 0) distinctCount--;

        if (distinctCount >= m) {
            if (currentSum > maxSum) maxSum = currentSum;
        }
    }

    return maxSum;
    
}

// Time complexity: O(n)