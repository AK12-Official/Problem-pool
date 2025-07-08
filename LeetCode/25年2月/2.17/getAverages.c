/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getAverages(int* nums, int numsSize, int k, int* returnSize) {
   
    *returnSize=numsSize;
    int *arr=(int*)malloc(sizeof(int)*numsSize);

    if (k == 0) {
        for (int i = 0; i < numsSize; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
    if (numsSize <= 2 * k) {
        for (int i = 0; i < numsSize; i++) {
            arr[i] = -1;
        }
        return arr;
    }

   
    for(int i=0;i<k;i++){
        arr[i]=-1;
        arr[numsSize-1-i]=-1;
        //ans+=nums[i]+nums[k+i];
    }

    long ans = 0;
    for (int i = 0; i < 2 * k + 1; i++) {
        ans += nums[i];
    }

    for (int i = k; i < numsSize - k; i++) {
        arr[i] = ans / (2 * k + 1);
        if (i + k + 1 < numsSize) {
            ans = ans - nums[i - k] + nums[i + k + 1];
        }
    }

    return arr;


}