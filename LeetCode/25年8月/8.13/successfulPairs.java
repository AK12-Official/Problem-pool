
import java.util.Arrays;

class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len1 = spells.length;
        int[] ans = new int[len1];
        Arrays.sort(potions);

        for (int i = 0; i < len1; i++) {
            ans[i] = potions.length - BinarySearch(potions, spells[i], success);
        }
        return ans;

    }

    private int BinarySearch(int[] potions, int spells, long success) {
        int left = 0;
        int right = potions.length ;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            long product = (long) potions[mid] * spells;

            if (product >= success) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    //1，2，3，3，3，3，3
    public static void main(String[] args) {
        int[] spells = new int[]{5, 1, 3};
        int[] potions = new int[]{1, 2, 3, 4, 5};
        long success = 7;
        System.out.println(Arrays.toString(new Solution().successfulPairs(spells, potions, success)));
    }
}
//一步步优化提高性能和鲁棒性

//首先是中间乘积的处理，potions[mid] * spells可能溢出int，故要使用long类型变量处理
//我一开始以为Java会自动分配一个能容纳的类型，看来我想多了

//然后是时间上的优化
//最开始是像前几天的做法一样
//给right取到length-1，采取三分支的if做处理
//利用while向前搜索重复元素返回第一个满足要求的分界点
//优化后right取到length
//采取二分支if right端点不再作为闭区间处理 不单独处理相等的情况
//如此迭代就可以找到第一个符合要求的分界

//从闭区间查找变成了左闭右开查找