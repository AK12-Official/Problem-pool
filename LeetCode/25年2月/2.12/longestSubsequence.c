int longestSubsequence(int* arr, int arrSize, int difference) {
    int* dp = (int*)malloc(arrSize * sizeof(int));
    memset(dp, 0, arrSize * sizeof(int));
    int maxLen = 1;
    int* hashTable = (int*)malloc(20001 * sizeof(int)); // 假设数组元素的范围是 -10000 到 10000
    memset(hashTable, 0, 20001 * sizeof(int));

    for (int i = 0; i < arrSize; i++) {
        int prevValue = arr[i] - difference + 10000;
        if (prevValue >= 0 && prevValue <= 20000 && hashTable[prevValue] > 0) {
            dp[i] = hashTable[prevValue] + 1;
        } else {
            dp[i] = 1;
        }
        hashTable[arr[i] + 10000] = dp[i];
        if (dp[i] > maxLen) {
            maxLen = dp[i];
        }
    }
    return maxLen;
}