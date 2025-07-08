#include <stdio.h>
#include <string.h>

int minInsertions(char* s) {
    int len = strlen(s);

    int dp[len + 1][len + 1];
    memset(dp, 0, sizeof(dp));

    for (int i = 0; i < len; i++) {
        dp[i][0] = 0;dp[0][i] = 0;
    }
  
    for (int i = 1; i <= len; i++) {
        for (int j = 1; j <= len; j++) {
            if (s[i-1]== s[len-j]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = fmax(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    int ans=len-dp[len][len];
    return ans;

}
int main() {
    char s[] = "zzazz";
    int result = minInsertions(s);
    printf("Minimum insertions needed for \"%s\": %d\n", s, result);
    return 0;
}


//注意16行处对s的i索引查找 由于s索引从0开始而i从1开始 所以从s[i-1]才能完整地遍历
// 最坏的情况就是在后面插入字符串s逆序，让其成为回文串，然后就是想办法减少插入的次数. 
// 即是从s的逆序里面找到跟s尽可能多的相同字符， 即时找s和s逆序的最长公共子序列。 
// 例如： leetcode + edocteel的LCS为 eee，输出s.size() - LCS(s, s.reverse)