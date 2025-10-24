import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int specialTriplets(int[] nums) {
        // value indexs
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }

        for (int j = 1; j < len - 1; j++) {
            int k = 2 * nums[j];
            List<Integer> list = map.get(k);
            if (list != null && list.size() > 0) {
                int pos = Collections.binarySearch(list, j);

                if (pos < 0) {
                    pos = -(pos + 1); // 转换为插入位置
                }

                int leftCount = pos;
                int rightCount = list.size() - pos;

                if (pos < list.size() && list.get(pos) == j) {
                    rightCount--; // j 右边的数量要减 1
                    // 用于处理0
                }

                ans = (ans + leftCount * rightCount) % 1000000007;
            }
        }
        return ans;
    }
}