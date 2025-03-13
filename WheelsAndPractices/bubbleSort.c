#include <stdio.h>
#include <stdlib.h>
#include "utils.h"

void bubbleSort(int arr[], int n)
{
    int swapped = 0;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - 1 - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap(&arr[j], &arr[j + 1]);
                swapped = 1;
            }
        }
        // 如果没有发生交换，数组已经有序
        if (!swapped)
        {
            break;
        }
        //可以在每一轮排序中检查是否进行了交换，如果没有进行交换，说明数组已经有序，可以提前退出循环。
    }
}

int main()
{
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr) / sizeof(arr[0]);
    bubbleSort(arr, n);
    printArray(arr, n);
    return 0;
}