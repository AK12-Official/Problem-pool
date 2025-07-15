
import java.util.List;
import java.util.Arrays;

class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        //统计元素个数
        int sumLen = 0;
        for (List<Integer> list : nums) {
            sumLen += list.size();
        }

        //创建 值-归属 键值对
        int[][] pairs = new int[sumLen][2];
        int pi = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int x : nums.get(i)) {
                pairs[pi][0] = x;
                pairs[pi++][1] = i;
            }
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int ansL = pairs[0][0];
        int ansR = pairs[sumLen - 1][0];
        int empty = nums.size();    //k
        int[] cnt = new int[empty];
        int left = 0;
        for (int[] p : pairs) {
            int r = p[0];
            int i = p[1];
            if (cnt[i] == 0) { // 包含 nums[i] 的数字
                empty--;
            }
            cnt[i]++;
            while (empty == 0) { // 每个列表都至少包含一个数
                int l = pairs[left][0];
                if (r - l < ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }
                i = pairs[left][1];
                cnt[i]--;
                if (cnt[i] == 0) { // 不包含 nums[i] 的数字
                    empty++;
                }
                left++;
            }
        }
        return new int[]{ansL, ansR};

    }
}
