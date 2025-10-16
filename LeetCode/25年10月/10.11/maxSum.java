
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int i = 0; i < len; i++) {
            int k = getMax(nums[i]);
            if (map.containsKey(k)) {
                ans = ans > map.get(k) + nums[i] ? ans : map.get(k) + nums[i];
            }
            map.put(k, nums[i]);
        }
        return ans;
    }

    private int getMax(int num) {
        int ret = 0;
        while (num != 0) {
            ret = ret > num % 10 ? ret : num % 10;
            num /= 10;
        }
        return ret;
    }
}

class SolutionPro {
    //还可以再改进  不存前两个 只存最大的一个 有相同最大数位就做和判断是否是更大的结果Sum 
    public int maxSum(int[] nums) {
        // 记录每个 maxDigit 的前两大数，初始为 -1 表示不存在
        int[][] top = new int[10][2];
        for (int i = 0; i < 10; i++) {
            top[i][0] = top[i][1] = -1;
        }

        for (int num : nums) {
            int d = getMax(num);
            if (num > top[d][0]) {
                top[d][1] = top[d][0];
                top[d][0] = num;
            } else if (num > top[d][1]) {
                top[d][1] = num;
            }
        }

        int ans = -1;
        for (int i = 0; i < 10; i++) {
            if (top[i][1] != -1) {
                ans = Math.max(ans, top[i][0] + top[i][1]);
            }
        }
        return ans;
    }

    private int getMax(int num) {
        int ret = 0;
        while (num != 0) {
            ret = Math.max(ret, num % 10);
            num /= 10;
        }
        return ret;
    }
}
