
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicatePro(int[] nums, int k) {
        int len = nums.length;

        int left = 0;
        int right = 0;

        Set<Integer> set = new HashSet();
        while (right < len) {
            if(set.contains(nums[right])){
                return true;
            }
            set.add(nums[right]);
            while (right-left>=k) { 
                set.remove(nums[left]);
                left++;
            }
            right++;
        }
        return false;
    }
}
