
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return Count(nums, k) - Count(nums, k - 1);
    }

    //  这里求取的是不同整数小于等于k的子数组
    public int Count(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            //！！！！！这里写小于等于就会给出错误答案，原因见Count方法的注释
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
