class Solution {
    public int longestOnes(int[] nums, int k) {
        int currentZero = 0;
        int ret = 0;
        int right = 0, left = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                currentZero++;
            if (currentZero > k) {
                //缩小窗口至符合条件
                if(nums[left]==0)currentZero--;
                left++;
            }
            ret=ret>right-left+1?ret:right-left+1;
        }
        return ret;
    }
}