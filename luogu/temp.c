// 将 1,2,…,9共9个数分成3组，分别组成3个三位数，且使这3个三位数构成1:2:3的比例
// 试求出所有满足条件的 3 个三位数。
#include <stdio.h>

int main() {
    for (int i = 100; i < 1000; i++) {
        int c = i;
        if (c % 10 == c / 10 % 10) continue;
        if (c / 10 % 10 == c / 100) continue;
        if (c % 10 == c / 100) continue;

        int a = 2 * i;
        int b = 3 * i;
        int d[10] = {0};
        int temp = c;

        for (int j = 0; j < 3; j++) {
            d[temp % 10]++;
            temp /= 10;
        }
        temp = a;
        for (int j = 0; j < 3; j++) {
            d[temp % 10]++;
            temp /= 10;
        }
        temp = b;
        for (int j = 0; j < 3; j++) {
            d[temp % 10]++;
            temp /= 10;
        }

        int mark = 1;
        for (int j = 1; j < 10; j++) {
            if (d[j] == 0)
                mark = 0;
        }
        if (mark)
            printf("%d %d %d\n", i, a, b);
    }

    return 0;
}