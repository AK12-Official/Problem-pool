
import java.util.Arrays;

class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int len = queries.length;
        int[] ans = new int[len];

        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));//按price升序

        // 预处理：计算前缀最大美丽值
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        for (int i = 0; i < len; i++) {
            int index = BinarySearch(items, queries[i] + 1);
            if (index == 0) {
                ans[i] = 0;
            } else {
                ans[i] = items[index - 1][1]; // 直接获取前缀最大值
            }
        }

        // for (int i = 0; i < len; i++) {
        //     int index = BinarySearch(items, queries[i] + 1);
        //     if (index == 0) {
        //         ans[i] = 0;
        //     } else {
        //         for (int j = 0; j < index; j++) {
        //             ans[i] = ans[i] > items[j][1] ? ans[i] : items[j][1];
        //         }
        //     }
        // }
        return ans;
    }

    private int BinarySearch(int[][] items, int queries) {
        int left = 0;
        int right = items.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (items[mid][0] < queries) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
