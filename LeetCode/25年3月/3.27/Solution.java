import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int Maxsum = 0;
        int CurrentSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        int left = 0, right = 0;
        for (right = 0; right < nums.length; right++) {
            while (countMap.getOrDefault(nums[right], 0) >= 1) {// 如果有重复元素
                // 缩小窗口
                countMap.remove(nums[left]);
                CurrentSum -= nums[left];
                left++;
            }
            countMap.put(nums[right], 1);
            CurrentSum += nums[right];
            Maxsum = Maxsum > CurrentSum ? Maxsum : CurrentSum;
        }
        return Maxsum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        System.out.println(s.maximumUniqueSubarray(nums));
    }

}