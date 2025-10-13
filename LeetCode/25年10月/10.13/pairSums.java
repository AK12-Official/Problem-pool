
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            //包含target-nums[i]
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) > 0){
                List<Integer> pair = new ArrayList<>();
                pair.add(target - nums[i]);
                pair.add(nums[i]);
                ans.add(pair);
                map.put(target - nums[i], map.get(target - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return ans;
    }
}
