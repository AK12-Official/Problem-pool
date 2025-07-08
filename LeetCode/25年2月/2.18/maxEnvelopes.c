int maxEnvelopes(int** envelopes, int envelopesSize, int* envelopesColSize) {
    int compare(const void* a, const void* b) {
        int* pairA = *(int**)a;
        int* pairB = *(int**)b;
        return pairA[0] - pairB[0];
    }

    qsort(envelopes, envelopesSize, sizeof(int*), compare);
    int dp[envelopesSize] = {};
    int left = 0;
    int right = 1;

    for (int i = 0; i < envelopesSize; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (envelopes[j][right] < envelopes[i][right] &&
                envelopes[j][left] < envelopes[i][left])
                dp[i] = fmax(dp[i], dp[j] + 1);
        }
        
    }
    int ans = dp[0];
    for (int i = 1; i < envelopesSize; i++) {
        ans = ans > dp[i] ? ans : dp[i];
    }
    return ans;
}
//O(n^2) time complexity

int maxEnvelopes(int** envelopes, int envelopesSize, int* envelopesColSize) {
    int compare(const void* a, const void* b) {
    int* pairA = *(int**)a;
    int* pairB = *(int**)b;
    if (pairA[0] == pairB[0]) {
        return pairB[1] - pairA[1]; // 如果宽度相同，则按高度降序排序
    }
    return pairA[0] - pairB[0]; // 否则按宽度升序排序
}

    if (envelopesSize == 0) return 0;

    qsort(envelopes, envelopesSize, sizeof(int*), compare);

    int* dp = (int*)malloc(envelopesSize * sizeof(int));
    int length = 0;

    for (int i = 0; i < envelopesSize; i++) {
        int left = 0, right = length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (dp[mid] < envelopes[i][1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        dp[left] = envelopes[i][1];
        if (left == length) length++;
    }
    return length;
}

//https://leetcode.cn/problems/russian-doll-envelopes/solutions/633231/e-luo-si-tao-wa-xin-feng-wen-ti-by-leetc-wj68/?envType=study-plan-v2&envId=dynamic-programming