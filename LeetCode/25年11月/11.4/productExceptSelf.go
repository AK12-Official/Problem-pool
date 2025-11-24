package temp

func productExceptSelf(nums []int) []int {
	pre := ProcessPre(nums)
	suf := ProcessSuf(nums)
	n := len(nums)
	ans := make([]int, n)
	for i := 0; i < n; i++ {
		ans[i] = pre[i] * suf[i+1]
	}
	return ans
}

func ProcessPre(nums []int) []int {
	n := len(nums)
	prefix := make([]int, n+1)
	prefix[0] = 1
	for i := 0; i < n; i++ {
		prefix[i+1] = prefix[i] * nums[i]
	}
	return prefix
}

func ProcessSuf(nums []int) []int {
	n := len(nums)
	prefix := make([]int, n+1)
	prefix[n] = 1
	for i := n - 1; i >= 0; i-- {
		prefix[i] = prefix[i+1] * nums[i]
	}
	return prefix
}

//泰哈人了 看到的别人的方案
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int pre = 1, suf = 1;
//         int[] ans = new int[n];
//         for (int i = 0; i < n; i++) {
//             ans[i] = pre;
//             pre *= nums[i];
//         }
//         for (int j = n - 1; j >= 0; j--) {
//             ans[j] *= suf;
//             suf *= nums[j];
//         }
//         return ans;
//     }
// }
