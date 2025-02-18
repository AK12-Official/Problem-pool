#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int uniquePathsWithObstacles(int **obstacleGrid, int obstacleGridSize,
                             int *obstacleGridColSize)
{
    int **dp;
    dp = (int **)malloc(sizeof(int *) * obstacleGridSize);
    for (int i = 0; i < obstacleGridSize; i++)
    {
        dp[i] = (int *)malloc(sizeof(int) * (*obstacleGridColSize));
        memset(dp[i], 0, sizeof(int) * (*obstacleGridColSize));
    }
    dp[0][0] = 1;
    if (obstacleGrid[0][0])dp[0][0] = 0;
    for (int i = 1; i < *obstacleGridColSize; i++)
    {
        if (obstacleGrid[0][i] == 1)
        {
            dp[0][i] = 0;
        }
        else
        {
            dp[0][i] = dp[0][i - 1];
        }
    }
    for (int i = 1; i < obstacleGridSize; i++)
    {
        if (obstacleGrid[i][0] == 1)
        {
            dp[i][0] = 0;
        }
        else
        {
            dp[i][0] = dp[i - 1][0];
        }
    }
    for (int i = 1; i < obstacleGridSize; i++)
    {
        for (int j = 1; j < *obstacleGridColSize; j++)
        {
            if (obstacleGrid[i][j])
                dp[i][j] = 0;
            else
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
    }
    return dp[obstacleGridSize - 1][*obstacleGridColSize - 1];
}

int main() {
    int grid[4][5] = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0}
    };

    int* obstacleGrid[4];
    for (int i = 0; i < 4; i++) {
        obstacleGrid[i] = grid[i];
    }

    int obstacleGridColSize = 5;
    int result = uniquePathsWithObstacles(obstacleGrid, 4, &obstacleGridColSize);
    printf("Unique paths: %d\n", result);

    return 0;
}




//您猜怎么着
//44行dp[i][j]=0写成dp[i][i]=0
//卡了半个小时手