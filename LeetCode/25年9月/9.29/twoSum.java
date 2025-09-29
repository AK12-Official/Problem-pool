
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(target - nums[i], 0));
            if (map.get(nums[i]) != 0) {
                ans[0] = map.get(nums[i]);
                ans[1] = nums[i];
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.err.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }
}
