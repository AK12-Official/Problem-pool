char* longestPalindrome(char* s) {
    int n = strlen(s);
    if (n == 0) return "";

    int dp[n][n];
    memset(dp, 0, sizeof(dp));

    int maxLength = 1;
    int start = 0;

    for (int i = 0; i < n; i++) {
        dp[i][i] = 1;
    }

    for (int i = 0; i < n - 1; i++) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = 1;
            start = i;
            maxLength = 2;
        }
    }

    for (int k = 3; k <= n; k++) {
        for (int i = 0; i < n - k + 1; i++) {
            int j = i + k - 1;
            if (dp[i + 1][j - 1] && s[i] == s[j]) {
                dp[i][j] = 1;
                if (k > maxLength) {
                    start = i;
                    maxLength = k;
                }
            }
        }
    }

    static char result[1000];
    strncpy(result, s + start, maxLength);
    result[maxLength] = '\0';
    return result;
}