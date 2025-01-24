// 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

// 请你计算并返回达到楼梯顶部的最低花费。
#include <stdio.h>

int minCostClimbingStairs(int* cost, int costSize) {
    int dp[costSize + 1];
    dp[0] = 0;
    dp[1] = 0;
    
    for (int i = 2; i <= costSize; i++) {
        dp[i] = (dp[i - 1] + cost[i - 1] < dp[i - 2] + cost[i - 2]) ? dp[i - 1] + cost[i - 1] : dp[i - 2] + cost[i - 2];
    }
    
    return dp[costSize];
}

int main() {
    int cost[] = {10, 15, 20};
    int costSize = sizeof(cost) / sizeof(cost[0]);
    printf("Minimum cost to reach the top: %d\n", minCostClimbingStairs(cost, costSize));
    return 0;
}

