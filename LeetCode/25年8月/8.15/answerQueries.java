
import java.util.Arrays;

class Solution {

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];

        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < m; i++) {
            ans[i] = BinarySearch(nums, queries[i]);
        }
        return ans;

    }

    private int BinarySearch(int[] nums, int queries) {
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= queries) {
                left = mid + 1;
            } else {
                right = mid;
            }       //mid及其右侧元素一定大于queries
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        int[] fixednums = {1, 3, 7, 12};
        // System.out.println(Arrays.toString(new Solution().answerQueries(nums, queries)));
        System.out.println(new Solution().BinarySearch(fixednums, 21));
    }
}

// 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
// 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
// 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
//debug记录：
//注意BinarySearch的循环不变量和区间开闭
//最开始给right赋到了m-1 导致成为闭区间带来错误
//一定一定一定要记住分析迭代过程中的循环不变量
