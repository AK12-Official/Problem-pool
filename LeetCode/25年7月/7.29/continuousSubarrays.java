
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

class Solution {

    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int left = 0;
        long ans = 0;

        for (int right = 0; right < nums.length; right++) {
            // 添加元素
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // 收缩窗口
            while (!map.isEmpty() && map.lastKey() - map.firstKey() > 2) {
                int leftVal = nums[left];
                map.put(leftVal, map.get(leftVal) - 1);
                if (map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }
                left++;
            }

            ans += right - left + 1;
        }
        return ans;
    }

    public long continuousSubarraysPro(int[] nums) {
        Deque<Integer> maxDeque = new ArrayDeque<>(); // 维护最大值索引
        Deque<Integer> minDeque = new ArrayDeque<>(); // 维护最小值索引

        int left = 0;
        long ans = 0;

        for (int right = 0; right < nums.length; right++) {
            // 维护递减的最大值队列
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // 维护递增的最小值队列
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // 收缩窗口
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sln = new Solution();
        int[] nums = new int[]{42, 41, 42, 41, 41, 40, 39, 38};
        System.out.println(sln.continuousSubarrays(nums));
    }
}
