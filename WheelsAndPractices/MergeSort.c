#include <stdio.h>
// 合并两个子数组 L 和 R 到数组 arr 中
// void merge(int arr[], int l, int m, int r)
// {
//     int i, j, k;
//     int n1 = m - l + 1;
//     int n2 = r - m;

//     // 创建临时数组
//     int L[n1], R[n2];

//     // 拷贝数据到临时数组 L[] 和 R[]
//     for (i = 0; i < n1; i++)
//         L[i] = arr[l + i];
//     for (j = 0; j < n2; j++)
//         R[j] = arr[m + 1 + j];

//     // 合并临时数组到 arr[l..r]
//     i = 0; // 初始化第一个子数组的索引
//     j = 0; // 初始化第二个子数组的索引
//     k = l; // 初始化合并后数组的索引
//     while (i < n1 && j < n2)
//     {
//         if (L[i] <= R[j])
//         {
//             arr[k] = L[i];
//             i++;
//         }
//         else
//         {
//             arr[k] = R[j];
//             j++;
//         }
//         k++;
//     }

//     // 拷贝 L[] 中的剩余元素
//     while (i < n1)
//     {
//         arr[k] = L[i];
//         i++;
//         k++;
//     }

//     // 拷贝 R[] 中的剩余元素
//     while (j < n2)
//     {
//         arr[k] = R[j];
//         j++;
//         k++;
//     }
// }

// // 使用归并排序对数组 arr[l..r] 进行排序
// void mergeSort(int arr[], int l, int r)
// {
//     if (l < r)
//     {
//         // 找到中间点
//         int m = l + (r - l) / 2;

//         // 对左半部分进行排序
//         mergeSort(arr, l, m);
//         // 对右半部分进行排序
//         mergeSort(arr, m + 1, r);

//         // 合并已排序的部分
//         merge(arr, l, m, r);
//     }
// }

//---------------------------------------------------------------------------

void merge(int *arr, int left, int mid, int right)
{
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int L[n1], R[n2];
    for (int i = 0; i < n1; i++)
    {
        L[i] = arr[left + i];
    }
    for (int i = 0; i < n2; i++)
    {
        R[i] = arr[mid + 1 + i];
    }
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2)
        arr[k++] = L[i] <= R[j] ? L[i++] : R[j++];
    while (i < n1)
        arr[k++] = L[i++];
    while (j < n2)
        arr[k++] = R[j++];
}
//先copy原数组到两个子数组，然后比较两个子数组的元素，将较小的元素放回原数组
//最后将剩余的元素放回原数组

void mergeSort(int *arr, int left, int right)
{
    if (left >= right)
        return;
    int mid = left + (right-left) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

int main(){
    int arr[] = {12, 3, 5, 7, 4, 19, 26};
    int n = sizeof(arr) / sizeof(arr[0]);
    mergeSort(arr, 0, n - 1);
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    return 0;
}