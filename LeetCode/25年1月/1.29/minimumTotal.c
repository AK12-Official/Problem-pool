#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int minFallingPathSum(int **matrix, int matrixSize, int *matrixColSize)
{
    int fmin(int a, int b, int c){
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    };
    int **dp;
    dp = (int **)malloc(sizeof(int *) * matrixSize);
    for (int i = 0; i < matrixSize; i++)
    {
        dp[i] = (int *)malloc(sizeof(int) * (matrixSize));
        memset(dp[i], 0, sizeof(int) * (matrixSize));
    }
    for (int i = 0; i < matrixSize; i++)
    {
        dp[0][i] = matrix[0][i];
    }
    for (int i = 1; i < matrixSize; i++)
    {
        for (int j = 0; j < *matrixColSize; j++)
        {
            if (j == 0)
            {
                dp[i][j] = fmin(dp[i - 1][j], dp[i - 1][j + 1], 999999) + matrix[i][j];
            }
            else if (j == matrixSize - 1)
            {
                dp[i][j] =
                    fmin(dp[i - 1][j - 1], dp[i - 1][j], 999999) + matrix[i][j];
            }
            else
            {
                dp[i][j] =
                    fmin(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
            }
        }
    }
    int ret = dp[matrixSize - 1][0];
    for (int i = 0; i < matrixSize; i++)
    {
        ret=ret < dp[matrixSize - 1][i] ? ret : dp[matrixSize - 1][i];
    }
    return ret;
}


//三元表达式啊我的宝
//三个三元表达式一个没写对




int main()
{
    int matrixSize = 2;
    int matrixColSize = 2;
    int *matrixColSizePtr = &matrixColSize;

    int data[2][2] = {
        {17, 82},
        {1, -44}
    };

    int **matrix = (int **)malloc(matrixSize * sizeof(int *));
    for (int i = 0; i < matrixSize; i++) {
        matrix[i] = (int *)malloc(matrixColSize * sizeof(int));
        for (int j = 0; j < matrixColSize; j++) {
            matrix[i][j] = data[i][j];
        }
    }

    int result = minFallingPathSum(matrix, matrixSize, matrixColSizePtr);
    printf("Minimum Falling Path Sum: %d\n", result);

    for (int i = 0; i < matrixSize; i++) {
        free(matrix[i]);
    }
    free(matrix);

    return 0;
}


