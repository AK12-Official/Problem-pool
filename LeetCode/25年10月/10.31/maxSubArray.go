package temp

func maxSubArray(nums []int) (ans int) {
	ans = nums[0]
	preSum := 0
	for _, v := range nums {
		if preSum+v < v {
			preSum = 0
		}
		preSum += v
		ans = max(ans, preSum)
	}
	return
}

/*这是经典的 Kadane 算法（动态规划＋贪心）的变体。

要点说明（简短）：
- 状态转移：设 dp[i] 为以 nums[i] 结尾的最大子数组和，则
  dp[i] = max(nums[i], dp[i-1] + nums[i])。
  意味着“以 i 结尾的最优子数组”要么从 i 新起，要么在前面子数组基础上延伸。
- 贪心直觉：如果 dp[i-1] 为正数，延伸能增大和；若为非正数，从当前元素重新开始更优。
- 代码用 preSum 维护以当前位置结尾的 dp 值，用 ans 记录全局最大值；单次遍历即得解，时间 O(n)，空间 O(1)。


简洁结论：这是 Kadane（线性扫描的动态规划/贪心），正确性来自最优子结构：以 i 结尾的最优解只依赖于 i-1 的最优解。*/
