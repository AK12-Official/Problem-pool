
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int findMaxK(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int ans = -1;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(-nums[i])) {
                ans = Math.max(ans, Math.abs(nums[i]));
            }
            map.put(nums[i], null);
        }
        return ans;
    }

    public int findMaxKPro(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (num > 0 && set.contains(-num)) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}
