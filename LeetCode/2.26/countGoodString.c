// 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：

// 将 '0' 在字符串末尾添加 zero  次。
// 将 '1' 在字符串末尾添加 one 次。
// 以上操作可以执行任意次。

// 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。

// 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。

#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int countGoodStrings(int low, int high, int zero, int one) {
    int* dp = (int*)malloc(sizeof(int) * (high + 1));
    memset(dp, 0, sizeof(int) * (high + 1));

    dp[0]=1;


    for (int i = 1; i <= high; i++) {
        if (i >= zero ) {
            dp[i] = (dp[i - zero] + dp[i])%1000000007;
        }
        if (i >= one && dp[i - one] != 0x3f3f3f3f) {
            dp[i] = (dp[i - one] + dp[i])%1000000007;
        }

    }

    int ans = 0;
    for (int i = low; i <= high; i++) {
        ans = (ans + dp[i]) % 1000000007;
    }
    return ans;
}


int main() {
    // 测试样例
    int low = 3;
    int high = 3;
    int zero = 1;
    int one = 1;

    // 调用函数并打印结果
    int result = countGoodStrings(low, high, zero, one);
    printf("Result for countGoodStrings(%d, %d, %d, %d): %d\n", low, high, zero, one, result);

    return 0;
}