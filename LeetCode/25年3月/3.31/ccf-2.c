#include<stdio.h>
#include<stdlib.h>

int main(){
    int n=0,m=0;
    int *Arr;
    Arr=(int *)malloc(sizeof(int)*(m+1));

    scanf("%d %d",&n,&m);
    
    Arr[0]=0;
    for(int i=0;i<m;i++){
        scanf("%d",&Arr[i+1]);
    }

    //投喂n个苹果获得的最大收益
    int dp[n+1];
    //初始化
    for(int i=0;i<n+1;i++){
        dp[i]=0;
    }

    //状态转移
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(i-j>=0)
            dp[i]=dp[i]>(dp[i-j]+Arr[j])?dp[i]:(dp[i-j]+Arr[j]);
        }
    }

    printf("%d",dp[n]);
    return 0;
}