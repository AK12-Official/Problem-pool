#include <stdlib.h>

int compare(const void* a, const void* b) {
    int* pairA = *(int**)a;
    int* pairB = *(int**)b;
    return pairA[0] - pairB[0];
}



int findLongestChain(int** pairs, int pairsSize, int* pairsColSize) {    
    qsort(pairs, pairsSize, sizeof(int*), compare);
    int dp[pairsSize]={0};
    int left=0;
    int right=1;



    for(int i=0;i<pairsSize;i++){
        dp[i]=1;
        for(int j=0;j<i;j++){
            if(pairs[j][right]<pairs[i][left]||)
                dp[i]=fmax(dp[i],dp[j]+1);
        }
    }
    
    int ans=dp[0];
    for(int i=1;i<pairsSize;i++){
        ans=ans>dp[i]?ans:dp[i];
    }
    return ans;
}