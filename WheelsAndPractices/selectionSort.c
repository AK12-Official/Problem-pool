#include <stdio.h>
#include <stdlib.h>
#include "utils.h"

void SelectionSort(int *Array, int ArraySize)
{
    for (int i = 0; i < ArraySize - 1; i++)
    {
        int minIndex = i;
        for (int j = i + 1; j < ArraySize; j++)
        {
            if (Array[j] < Array[minIndex])
            {
                minIndex = j;
            }
        }
        swap(&Array[minIndex], &Array[i]);
    }
}

int main(){
    int arr[] = {64, 25, 12, 22, 11};
    int n = sizeof(arr) / sizeof(arr[0]);
    SelectionSort(arr, n);
    printArray(arr, n);
    system("pause");
    return 0;
}