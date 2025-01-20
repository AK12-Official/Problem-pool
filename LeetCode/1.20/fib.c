int fib(int n) {
    if (n > 1)
        return fib(n - 2) + fib(n - 1);
    if (n == 1)
        return 1;
    if (n == 0)
        return 0;
    return -1;
}
//--------------------------------  
int fib(int n) {
    if (n < 2) {
        return n;
    }
    int p = 0, q = 0, r = 1;
    for (int i = 2; i <= n; ++i) {
        p = q;
        q = r;
        r = p + q;
    }
    return r;
}

