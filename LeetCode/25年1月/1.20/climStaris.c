// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

int climbStairs(int n) {
    int ans[45] = {0};
    ans[0]=1;ans[1]=2;
    for(int i=2;i<45;i++)
    {
        ans[i]=ans[i-1]+ans[i-2];
    }
    return ans[n-1];
}



// 思路：动态规划，爬到第n阶楼梯的方法数等于爬到第n-1阶楼梯的方法数加上爬到第n-2阶楼梯的方法数

// 官解：使用滚动数组节省空间
// class Solution {
// public:
//     int climbStairs(int n) {
//         int p = 0, q = 0, r = 1;
//         for (int i = 1; i <= n; ++i) {
//             p = q; 
//             q = r; 
//             r = p + q;
//         }
//         return r;
//     }
// };

// 时间复杂度：O(n)。单循环到 n 。
