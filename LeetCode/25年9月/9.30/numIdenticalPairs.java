
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                ret += map.get(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
        return ret;
    }
}
