
import java.util.HashMap;
import java.util.Map;

class Solution {

    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right;

        long ans = 0;

        int CurrentPairs = 0;
        for (right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (map.get(nums[right]) > 1) {
                CurrentPairs += map.get(nums[right]) - 1;
            }

            while (CurrentPairs >= k) {

                if (map.get(nums[left]) > 1) {
                    CurrentPairs -= map.get(nums[left]) - 1;
                }

                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            ans += left;
        }
        return ans;
    }

}

//注意返回值
//痛失时空复杂度