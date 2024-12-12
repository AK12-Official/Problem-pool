//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。

// 示例 1:

// 输入: s = "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:

// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:

// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


#include <stdio.h>
#include <stdbool.h>
int lengthOfLongestSubstring(char* s) {
    int ans = 0, left = 0;
    bool has[128] = {};
    for (int right = 0; s[right]; right++) 
    {
        char c = s[right];
        while (has[c]) 
        { // 窗口内有 c
        has[s[left]] = false;
        left++; // 缩小窗口
        }
        has[c] = true;
        ans=ans>right-left+1?ans:right-left+1;
    }
    return ans;
}

//滑动窗口算法
//https://www.bilibili.com/video/BV1hd4y1r7Gq/?vd_source=0437aa3fbc324cf2cc3e7f8ca395e67c


//AI说：
// 具体步骤如下：

// 滑动窗口：使用滑动窗口技术来解决这个问题。滑动窗口通过两个指针（left 和 right）来维护一个窗口，窗口内的字符是当前正在检查的子串。

// 初始化：定义变量 ans 用于存储最长子串的长度，left 用于指向窗口的左边界，has 数组用于记录窗口内字符是否存在。

// 遍历字符串：使用 right 指针遍历字符串 s。

// 对于每个字符 s[right]，检查 has 数组中是否已经存在该字符。
// 如果存在（即 has[c] 为 true），则说明当前窗口内有重复字符，需要缩小窗口。通过移动 left 指针并将 has[s[left]] 置为 false 来缩小窗口，直到窗口内没有重复字符。
// 将当前字符 s[right] 标记为存在（即 has[c] 置为 true）。
// 更新最长子串的长度 ans。
// 返回结果：遍历结束后，返回最长子串的长度 ans。

// 通过这种方式，可以在一次遍历中找到无重复字符的最长子串，时间复杂度为 O(N)。