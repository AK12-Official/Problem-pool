class Solution {
    public int climbStairs(int n) {

        int[] ans = new int[45];
        ans[0] = 1;
        ans[1] = 2;
        for (int i = 2; i < 45; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n - 1];
    }
}

// 官解：
// class Solution {
// public int climbStairs(int n) {
// int p = 0, q = 0, r = 1;
// for (int i = 1; i <= n; ++i) {
// p = q;
// q = r;
// r = p + q;
// }
// return r;
// }
// }
