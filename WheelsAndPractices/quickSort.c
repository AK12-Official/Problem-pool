void quickSort(int *arr, int left, int right)
{
    if (left >= right)
    {
        return;
    }
    // 分区
    int pivot = Partition(arr, left, right);
    qucikSort(arr, left, pivot - 1);
    qucikSort(arr, pivot + 1, right);
}

int Partition(int *arr, int left, int right)
{
    // 优化点 随机选取pivot
    // int randomIndex = left + rand() % (right - left + 1);
    // swap(arr, randomIndex, right); // 将随机选择的 pivot 放到最后

    // 选取最后一个元素作为pivot
    int pivot = arr[right];

    // 从左到右遍历，小于pivot的元素放到左边
    int i = left;
    for (int j = left; j < right; j++)
    {
        if (arr[j] < pivot)
        {
            swap(arr, i, j);
            i++;
        }
    }

    // 将pivot放到中间
    swap(arr, i, right);

    // 返回pivot的位置
    return i;
}

// 接下来的改进方向   自定义升序降序