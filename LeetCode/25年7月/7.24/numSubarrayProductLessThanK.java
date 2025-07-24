
class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;   //即使数组中有0也无法严格小于
        }

        long product = 1;

        int left = 0, right;
        int ans = 0;

        for (right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
                if (left > right) {
                    break;      //处理k==1可能带来的问题
                }
            }
            ans += right - left + 1;
        }
        return ans;
    }
    // k==1 也可以直接返0  nums中元素最小是1不是0         
    public static void main(String[] args) {
        Solution sln = new Solution();

        int[] nums = new int[]{1, 1, 1};
        int k = 1;
        System.out.println(sln.numSubarrayProductLessThanK(nums, k));
    }
}
