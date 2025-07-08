int findKthLargest(int* nums, int numsSize, int k) {
    // 先找一个元素进行分区 找到第x大
    int left = 0;
    int right = numsSize - 1;
    while (left <= right) {
        if (left == right)
            return nums[left];

        int pivotIndex = left + rand() % (right - left + 1);
        int pivot = nums[pivotIndex];
        nums[pivotIndex] = nums[left];
        nums[left] = pivot;

        // 分区
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) // 不加等号就超时 估计是形成环路了
                j--;
            nums[i] = nums[j]; // 此时pivot在j处
            while (i < j && nums[i] <= pivot)
                i++;
            nums[j] = nums[i]; // 此时pivot在i处
        }
        nums[i] = pivot;

        if (numsSize - i == k)
            return nums[i];
        else if (numsSize - i > k)
            left = i + 1;
        else {
            right = i - 1;
            // k = k - (numsSize - i);
        }
    }
    return -1;
}