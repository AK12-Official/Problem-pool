#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>



bool wordBreak(char* s, char** wordDict, int wordDictSize) {
    // int n = strlen(s);

    // int dp[n][n];
    // memset(dp, 0, sizeof(dp));

    // for(int i=0;i<n;i++){
    //     for(int j=0;j<wordDictSize;j++){
    //         int len = strlen(wordDict[j]);
    //         if(i+len-1<n && strncmp(s+i, wordDict[j], len)==0){
    //             dp[i][i+len-1] = 1;
    //         }
    //     }
    // }
    
    // for(int len=2;len<=n;len++){
    //     for(int i=0;i+len-1<n;i++){
    //         for(int j=i;j<i+len-1;j++){
    //             if(dp[i][j] && dp[j+1][i+len-1]){
    //                 dp[i][i+len-1] = 1;
    //                 break;
    //             }
    //         }
    //     }
    // }
    // return dp[0][n-1];

    int n=strlen(s);

    int dp[n+1];
    memset(dp, 0, sizeof(dp));

    dp[0] = 1;

    for(int i=0;i<n;i++){
        if(dp[i]){
            for(int j=0;j<wordDictSize;j++){
                int len=strlen(wordDict[j]);
                if(i+len<=n&&strncmp(s+i, wordDict[j],len)==0){
                    dp[i+len] = 1;
                }
            }
        }
    }

    return dp[n];
}