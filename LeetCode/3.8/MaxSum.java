// 给你一个整数数组 nums 和两个正整数 m 和 k 。

// 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。

// 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。

// 子数组指的是一个数组中一段连续 非空 的元素序列。
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSum {
    public long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            if (i >= k) {
                currentSum -= nums.get(i - k);
                countMap.put(nums.get(i - k), countMap.get(nums.get(i - k)) - 1);// 更新 countMap 中窗口左边界元素的出现次数，将其减 1
                if (countMap.get(nums.get(i - k)) == 0) {
                    countMap.remove(nums.get(i - k)); // 如果窗口左边界元素的出现次数为 0，则将其从 countMap 中移除。
                }
            }

            currentSum += nums.get(i); // 将窗口右边界元素的值加到 currentSum 中
            countMap.put(nums.get(i), countMap.getOrDefault(nums.get(i), 0) + 1);
            // 更新 countMap 中窗口右边界元素的出现次数，将其加 1。如果元素不存在，则使用 getOrDefault 方法返回默认值 0。
            if (i >= k - 1 && countMap.size() >= m) {
                maxSum = Math.max(maxSum, currentSum);
            }
            // 如果当前索引 i 大于等于 k - 1，表示窗口已经形成，并且 countMap 中不同元素的数量大于等于 m，则更新 maxSum。
        }

        return maxSum;
    }

}