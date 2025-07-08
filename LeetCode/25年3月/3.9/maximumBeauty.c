/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define INDEX_PRICE 0
#define INDEX_BEAUTY 1

// int* maximumBeauty(int** items, int itemsSize, int* itemsColSize, int* queries, int queriesSize, int* returnSize) {
//     *returnSize=queriesSize;

//     int *ret=(int *)malloc(sizeof(int)*queriesSize);
//     for(int i=0;i<queriesSize;i++){
//         int max=0;
//         for(int j=0;j<itemsSize;j++){
//             if(queries[i]>=items[j][INDEX_PRICE]){
//                 max=max>items[j][INDEX_BEAUTY]?max:items[j][INDEX_BEAUTY];
//             }
//         }
//         ret[i]=max;
//     }
//     return ret;
// }

// 这么写包超时的

int compare(const void *a, const void *b)
{
    return (*(int **)a)[INDEX_PRICE] - (*(int **)b)[INDEX_PRICE];
}

int *maximumBeauty(int **items, int itemsSize, int *itemsColSize, int *queries, int queriesSize, int *returnSize)
{
    *returnSize = queriesSize;
    int *ret = (int *)malloc(sizeof(int) * queriesSize);
    int *maxBeauty = (int *)malloc(sizeof(int) * itemsSize);

    qsort(items, itemsSize, sizeof(int *), compare);

    maxBeauty[0] = items[0][INDEX_BEAUTY];
    for (int i = 1; i < itemsSize; i++)
    {
        maxBeauty[i] = maxBeauty[i - 1] > items[i][INDEX_BEAUTY] ? maxBeauty[i - 1] : items[i][INDEX_BEAUTY];
    }

    for (int i = 0; i < queriesSize; i++)
    {
        int left = 0;
        int right = itemsSize - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (queries[i] >= items[mid][INDEX_PRICE])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        ret[i] = right >= 0 ? maxBeauty[right] : 0;
    }

    free(maxBeauty);
    return ret;
}