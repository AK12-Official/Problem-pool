#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int change(int amount, int *coins, int coinsSize)
{

    int *dp = (int *)malloc(sizeof(int) * (amount + 1));
    memset(dp, 0, sizeof(int) * (amount + 1));

    dp[0] = 1;

    for(int j=0; j<coinsSize; j++)
    {
        for(int i=1; i<=amount; i++)
        {
            if(i-coins[j] >= 0)
            {
                dp[i] += dp[i-coins[j]];
            }
        }
    }

    return dp[amount];
}


int main()
{
    int coins[] = {1, 2, 5};
    int coinsSize = 3;
    int amount = 5;
    int result = change(amount, coins, coinsSize);
    printf("result = %d\n", result);
    return 0;
}