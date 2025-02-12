// 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。

// 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。


int maximumWealth(int** accounts, int accountsSize, int* accountsColSize) {
    int Max=0;
    int m=accountsSize;
    int n=*accountsColSize;
    for(int i=0;i<m;i++)
    {
        int sum=0;
        for(int j=0;j<n;j++)
        {
            sum+=accounts[i][j];
        }
        Max=Max>sum?Max:sum;
    }
    return Max;
}

//accounts是一个二维数组，accountsSize是行数，accountsColSize是列数

//int accounts[accountsSize][accountsColSize];  
//              行数           每行几个元素(即列数)   