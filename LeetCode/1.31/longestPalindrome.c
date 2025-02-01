#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//建议对比三个版本进行比较学习
//本文件注释版（V1）
//本文件无注释版（V2）
//longest（V3）

char* longestPalindrome(char* s) {
    int length = strlen(s);
    if (length == 0) return 0;

   int **dp = (int**)malloc(sizeof(int*) * length);
    for (int i = 0; i < length; i++) {
        dp[i] = (int*)calloc(length, sizeof(int));
        dp[i][i] = 1;
    }


    // for(int i=0;i<length;i++){
    //     for(int j=i+1;j<length;j++){
    //         if(j==i+1){
    //             if(s[i]==s[j]){
    //                 dp[i][j]=1;
    //             }
    //         }
    //         if(j>i+1){
    //             if(s[i]==s[j]&&dp[i+1][j-1]==1){
    //                 dp[i][j]=1;
    //             }
    //         }
    //     }
    // }
    //这部分代码是错误的，因为在计算某些区间时，该区间的依赖项可能还没有计算，所以需要从长度为2的区间开始计算

    for(int len=2; len<=length; len++){
        for(int i=0; i<=length-len; i++){
            int j = i+len-1;
            if(s[i]==s[j]){
                if(len==2){
                    dp[i][j]=1;
                } else if(dp[i+1][j-1]==1){
                    dp[i][j]=1;
                }
            }
        }
    }
        
    int max=0;
    int start=0;
    int end=0;
    for(int i=0;i<length;i++){
        for(int j=i;j<length;j++){
            if(dp[i][j]==1){
                if(j-i>max){
                    max=j-i;
                    start=i;
                    end=j;
                }
            }
        }
    }

    char *result;
    result = (char*)malloc(sizeof(char) * (end-start+2));
    for(int i=start;i<=end;i++){
        result[i-start]=s[i];
    }
    result[end-start+1]='\0';
    return result;

}



// char* longestPalindrome(char* s) {
//     int length = strlen(s);
//     if (length == 0) return "";

//     int start = 0, maxLength = 1;

//     int **dp = (int**)malloc(sizeof(int*) * length);
//     for (int i = 0; i < length; i++) {
//         dp[i] = (int*)calloc(length, sizeof(int));
//         dp[i][i] = 1;
//     }

//     for (int len = 2; len <= length; len++) {
//         for (int i = 0; i <= length - len; i++) {
//             int j = i + len - 1;
//             if (s[i] == s[j] && (len == 2 || dp[i + 1][j - 1])) {
//                 dp[i][j] = 1;
//                 if (len > maxLength) {
//                     start = i;
//                     maxLength = len;
//                 }
//             }
//         }
//     }

//     char *result = (char*)malloc(sizeof(char) * (maxLength + 1));
//     strncpy(result, s + start, maxLength);
//     result[maxLength] = '\0';

//     for (int i = 0; i < length; i++) {
//         free(dp[i]);
//     }
//     free(dp);

//     return result;
// }

void test_longestPalindrome() {
    char input[] = "aaaa";
    char* result = longestPalindrome(input);
    printf("Longest palindrome substring of '%s' is '%s'\n", input, result);
    free(result);
}

int main() {
    test_longestPalindrome();
    return 0;
}