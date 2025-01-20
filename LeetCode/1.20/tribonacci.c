// 泰波那契序列 Tn 定义如下： 

// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

int tribonacci(int n) {
    if (n == 0)
        return 0;
    if (n < 3)
        return 1;
    int a, b, c, ans;
    a = 0;
    b = 1;
    c = 1;
    ans = 2;
    for (int i = 3; i < n; i++) {
        a = b;
        b = c;
        c = ans;
        ans = a + b + c;
    }
    return ans;
}