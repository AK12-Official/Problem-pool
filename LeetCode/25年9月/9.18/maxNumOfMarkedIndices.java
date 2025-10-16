
import java.util.Arrays;

class Solution {

        public int maxNumOfMarkedIndices(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int left = 0, right = len / 2;

        while (left < right) {
            int mid = right - (right - left) / 2; 
            if (check(nums, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left * 2;
    }

    private boolean check(int[] nums, int pairNum) {
        int len = nums.length;
        int left = 0;
        int right = len - pairNum;
        for (int i = 0; i < pairNum; i++) {
            if (nums[left + i] * 2 > nums[right + i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 5, 4};
        System.err.println(new Solution().maxNumOfMarkedIndices(nums) + "  123");
    }

//我知道这可能有一点反直觉 但是得分前后半区配对



}
