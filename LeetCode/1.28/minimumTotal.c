#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int minimumTotal(int** triangle, int triangleSize, int* triangleColSize) {

    // if(triangleSize==1)
    // {
    //     return triangle[0][0];  
    // }
    // if (triangleSize == 2)
    // {
    //     return triangle[0][0] + (triangle[1][0] < triangle[1][1] ? triangle[1][0] : triangle[1][1]);
    // }
    

    int **dp;
    dp = (int**)malloc(sizeof(int*) * triangleSize);
    for (int i = 0; i < triangleSize; i++) {
        dp[i] = (int*)malloc(sizeof(int) * (triangleColSize[i]));
        memset(dp[i], 0, sizeof(int) * (triangleColSize[i]));
    }

    dp[0][0]=triangle[0][0];
    for(int i=1;i<triangleSize;i++){
        dp[i][0]=triangle[i][0]+dp[i-1][0];
    }
    for(int i=1;i<triangleSize;i++){
        for(int j=1;j<=i;j++){
            if(j<i){
                dp[i][j]=(dp[i-1][j]+triangle[i][j])<(dp[i-1][j-1]+triangle[i][j])?(dp[i-1][j]+triangle[i][j]):(dp[i-1][j-1]+triangle[i][j]);
            }
            else{
                dp[i][j]=dp[i-1][j-1]+triangle[i][j];
            }
        }
    }
    int ret=dp[triangleSize-1][0];
    for(int i=1;i<triangleSize;i++){
        ret=(ret)<(dp[triangleSize-1][i])?(ret):(dp[triangleSize-1][i]);
    }
    return ret;
}


//*triangleColSize是一个指向整数的指针，通常用于表示一个数组的列数。
//在这个上下文中，triangleColSize是一个指向整数数组的指针，每个元素表示triangle中对应行的列数。


int main() {
    int triangleSize = 4;
    int triangleColSize[] = {1, 2, 3, 4};
    int** triangle = (int**)malloc(sizeof(int*) * triangleSize);
    triangle[0] = (int*)malloc(sizeof(int) * 1);
    triangle[1] = (int*)malloc(sizeof(int) * 2);
    triangle[2] = (int*)malloc(sizeof(int) * 3);
    triangle[3] = (int*)malloc(sizeof(int) * 4);

    triangle[0][0] = 2;
    triangle[1][0] = 3;
    triangle[1][1] = 4;
    triangle[2][0] = 6;
    triangle[2][1] = 5;
    triangle[2][2] = 7;
    triangle[3][0] = 4;
    triangle[3][1] = 1;
    triangle[3][2] = 8;
    triangle[3][3] = 3;

    int result = minimumTotal(triangle, triangleSize, triangleColSize);
    printf("Minimum Total: %d\n", result);

    for (int i = 0; i < triangleSize; i++) {
        free(triangle[i]);
    }
    free(triangle);

    return 0;
}