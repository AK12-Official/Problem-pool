
import java.lang.reflect.Array;
import java.util.Arrays;

// class Solution {
//     public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
//         int len = nums1.length;
//         int[][] Diff = new int[len][2];
//         for (int i = 0; i < len; i++) {
//             Diff[i][0] = Math.abs(nums1[i] - nums2[i]);
//             Diff[i][1] = i;
//         }
//         // Arrays.sort(Diff, (a, b) -> Integer.compare(a[0], b[0]));
//         Arrays.sort(Diff, (a, b) -> a[0] - b[0]);
//         int maxDiffIndex = 0;
//         int temp = Diff[0][0];
//         for (int i = 1; i < len; i++) {
//             temp = temp > Diff[i][0] ? temp : Diff[i][0];
//             maxDiffIndex = temp > Diff[i][0] ? maxDiffIndex : Diff[i][1];
//         }
//         int num1Val = nums1[maxDiffIndex];
//         int num2Val = nums2[maxDiffIndex];
//         int DiffBefore = Math.abs(num1Val - num2Val);
//         Arrays.sort(nums1);
//         //查找最接近的元素
//         int left = 0;
//         int right = nums1.length;
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (nums1[mid] < num2Val) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }
//         //left ->第一个>=num2Val的元素的下标
//         int Closest;
//         if (left == 0) {
//             Closest = nums1[left];
//         } else {
//             Closest = Math.abs(num2Val - nums1[left - 1]) > Math.abs(num2Val - nums1[left]) ? nums1[left] : nums1[left - 1];
//         }
//         int newDiff = Math.abs(num2Val - Closest);
//         int ans = 0;
//         for (int i = 0; i < len; i++) {
//             ans += Diff[i][0];
//         }
//         return (ans + newDiff - DiffBefore) % (1000000007);
//     }
// }
//好吧 这个算法不出意外是错误的
//贪心是不对的
//对每个元素 二分查找其有序下标 然后替换为前/后元素 返回一个更新后的绝对值差 遍历一遍就可以找到最小值，nlogn的复杂度 我觉得可以接受
class Solution {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int MOD = 1_000_000_007;
        int[] nums1Sorted = nums1.clone();
        Arrays.sort(nums1Sorted);

        long totalDiff = 0;
        int maxReduce = 0;

        for (int i = 0; i < len; i++) {
            int a = nums1[i], b = nums2[i];
            int currDiff = Math.abs(a - b);
            totalDiff = (totalDiff + currDiff) % MOD;

            // 二分查找nums1Sorted中最接近b的元素
            int idx = lowerBound(nums1Sorted, b);
            int bestDiff = currDiff;
            if (idx < len) {
                bestDiff = Math.min(bestDiff, Math.abs(nums1Sorted[idx] - b));
            }
            if (idx > 0) {
                bestDiff = Math.min(bestDiff, Math.abs(nums1Sorted[idx - 1] - b));
            }
            maxReduce = Math.max(maxReduce, currDiff - bestDiff);
        }
        return (int)((totalDiff - maxReduce + MOD) % MOD);
    }

    // 返回第一个>=target的下标
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
