class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}


假设整数 num 的十进制表示有 n 位，从最低位到最高位依次是 a 
0
​
  到 a 
n−1
​
 ，则 num 可以写成如下形式：

num
​
  
= 
i=0
∑
n−1
​
 a 
i
​
 ×10 
i
 
= 
i=0
∑
n−1
​
 a 
i
​
 ×(10 
i
 −1+1)
= 
i=0
∑
n−1
​
 a 
i
​
 ×(10 
i
 −1)+ 
i=0
∑
n−1
​
 a 
i
​
 
​
 
当 i=0 时，10 
i
 −1=0 是 9 的倍数；当 i 是正整数时，10 
i
 −1 是由 i 位 9 组成的整数，也是 9 的倍数。因此对于任意非负整数 i，10 
i
 −1 都是 9 的倍数。由此可得 num 与其各位相加的结果模 9 同余。重复计算各位相加的结果直到结果为一位数时，该一位数即为 num 的数根，num 与其数根模 9 同余。

我们对 num 分类讨论：

num 不是 9 的倍数时，其数根即为 num 除以 9 的余数。

num 是 9 的倍数时：

如果 num=0，则其数根是 0；

如果 num>0，则各位相加的结果大于 0，其数根也大于 0，因此其数根是 9。

作者：力扣官方题解
链接：https://leetcode.cn/problems/add-digits/solutions/1301157/ge-wei-xiang-jia-by-leetcode-solution-u4kj/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。