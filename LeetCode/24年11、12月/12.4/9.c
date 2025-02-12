// 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

// 回文数
// 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

// 例如，121 是回文，而 123 不是。
 


#include <stdbool.h>

bool isPalindrome(int x) {
    if (x < 0)
        return false;
    if (x == 0)
        return true;
    if (x < 10)
        return true;
    if(x%10==0)              //这个if没啥用 不影响结果 但是可以减少一些不必要的运算()
        return false;          //加上这个if后 从 7ms 减少到 0ms     (在力扣平台上)
    int copy;
    int length = 0;
    for (copy = x; copy > 0; copy /= 10) {
        length++;
    }
    if (length % 2 == 0) {
        int a[length / 2];
        for (int i = 0; i < length / 2; i++) {
            a[i] = x % 10;
            x /= 10;
        }
        int i = 0;
        for (x; x > 0; x /= 10) {
            if (x % 10 != a[length / 2 - 1 - i])
                return false;
            i++;
        }
        return true;
    } else {
        int a[length / 2];
        for (int i = 0; i < length / 2; i++) {
            a[i] = x % 10;
            x /= 10;
        }
        int i = 0;
        x /= 10;
        for (x; x > 0; x /= 10) {
            if (x % 10 != a[length / 2 - 1 - i])
                return false;
            i++;
        }
        return true;
    }
}


//多位回文数一定是11的倍数
