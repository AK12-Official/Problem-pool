import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int right;
        Map<Integer, Integer> count = new HashMap<>();

        int maxLength = 0;
        for (right = 0; right < nums.length; right++) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            while (count.getOrDefault(nums[right], 0) > k) {
                // 缩小窗口
                count.put(nums[left], count.get(nums[left]) - 1);
                left++;
            }
            maxLength = right - left + 1 > maxLength ? right - left + 1 : maxLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = { 1, 2, 1, 2, 1, 2, 1, 2 };
        System.out.println(s.maxSubarrayLength(nums, 1));
    }
}