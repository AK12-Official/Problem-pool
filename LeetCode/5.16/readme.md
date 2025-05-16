# Record

## 思路记录

最开始的想法：  
从数组尾部开始求和，找到sum>x的位置，从这个位置开始求取滑动窗口（利用取模的方法），得到一个minOps，但是这么做的问题是：程序无法处理形如

``` C
nums=[3,2,20,1,1,3]
x=10
```

这样的输入，而且不能很好的结合滑动窗口的形式求解

## Fix

改换思路，题目要求和为x的两端元素，我们可以转化为求取和为total-x的子数组，转化为正常的滑动窗口，可以更好的处理边界情况等

## 题解

[LeetCode官方题解](https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/solutions/2047253/jiang-x-jian-dao-0-de-zui-xiao-cao-zuo-s-hl7u/)
