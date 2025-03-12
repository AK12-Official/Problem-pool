/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *decrypt(int *code, int codeSize, int k, int *returnSize)
{
    *returnSize = codeSize;
    int *ret = (int *)malloc(sizeof(int) * codeSize);
    memset(ret, 0, sizeof(int) * codeSize);
    if (k == 0)
    {
        for (int i = 0; i < codeSize; i++)
        {
            ret[i] = 0;
        }
        return ret;
    }
    else if (k > 0)
    {
        int sum = 0;
        for (int i = 0; i < k; i++)
        {
            sum += code[i];
        }
        for (int i = 0; i < codeSize; i++)
        {
            // 将sum赋值给某元素
            ret[(codeSize - 1 + i) % codeSize] = sum;
            // 修改sum的值
            sum = sum - code[i] + code[(i + k) % codeSize];
        }
    }
    else
    {
        int sum = 0;
        k = -k;
        for (int i = 0; i < k; i++)
        {
            sum += code[i];
        }
        for (int i = 0; i < codeSize; i++)
        {
            // 将sum赋值给某元素
            ret[(codeSize - 1 + i) % codeSize] = sum;
            // 修改sum的值
            sum = sum - code[i] + code[(i + k) % codeSize];
        }
    }
    return ret;
}


void printArray(int* arr, int size) {
    printf("[");
    for (int i = 0; i < size; i++) {
        printf("%d", arr[i]);
        if (i < size - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}


int main()
{
    int code[] = {5, 7, 1, 4};
    int codeSize = sizeof(code) / sizeof(code[0]);
    int returnSize;
    int k = 3; // 你可以根据需要修改 k 的值

    int *result = decrypt(code, codeSize, k, &returnSize);

    printf("输入: ");
    printArray(code, codeSize);
    printf("k = %d\n", k);
    printf("输出: ");
    printArray(result, returnSize);

    free(result);

    return 0;
}