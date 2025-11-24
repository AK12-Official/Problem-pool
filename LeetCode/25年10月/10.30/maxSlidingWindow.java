import java.util.TreeMap;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k == 0) {
            return new int[0];
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int left = 0;
        int[] ans = new int[len - k + 1];
        for (int right = 0; right < len; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (right - left + 1 > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            if (right - left + 1 == k) {
                ans[left] = map.lastKey();
            }
        }

        return ans;
    }
}