
class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        //计算大于等于
        return Count(nums,k) - Count(nums, k + 1);

    }

    public int Count(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            k -= nums[right] % 2;
            //越长越合法
            while (k <= 0) {
                k += nums[left] % 2;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}

//哎呀哎呀哎呀
//问题分析这一块，一遍过这一块
