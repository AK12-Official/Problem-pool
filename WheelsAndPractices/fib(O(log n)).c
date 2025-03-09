#include <stdio.h>

// 乘法矩阵
void multiply(int F[2][2], int M[2][2]) {
    int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
    int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
    int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
    int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
}

// 幂矩阵
// void power(int F[2][2], int n) {
//     if (n == 0 || n == 1)
//         return;
//     int M[2][2] = {{1, 1}, {1, 0}};

//     power(F, n / 2);
//     multiply(F, F);

//     if (n % 2 != 0)
//         multiply(F, M);
// }

// // 返回第n个斐波那契数
// int fib(int n) {
//     int F[2][2] = {{1, 1}, {1, 0}};
//     if (n == 0)
//         return 0;
//     power(F, n - 1);
//     return F[0][0];
// }



void power(int F[2][2],int n){
    if(n==0||n==1)
        return;
    int M[2][2]={{0,1},{1,1}};
    power(F,n/2);
    multiply(F,F);
    if(n%2!=0)
        multiply(F,M);
}

int fib(int n){
    int F[2][2]={{0,1},{1,1}};
    if(n==0)
        return 0;
    power(F,n);
    return F[0][1];
}

// 主函数
int main() {
    int n = 10;
    printf("Fibonacci number %d is %d\n", n, fib(n));
    return 0;
}

//[{f(n+1),f(n)},{f(n),f(n-1)}] = [{1,1},{0,1}]^(n-1)  //第一种
//[{f(n-1),f(n)},{f(n),f(n+1)}] = [{0,1},{1,1}]^(n)    //第二种
//两种不同方法原理都是用的矩阵乘法 只不过初始矩阵不太一致

