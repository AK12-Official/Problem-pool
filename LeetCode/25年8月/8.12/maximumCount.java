
class Solution {

    public int maximumCount(int[] nums) {
        int pos = nums.length - BinarySearch(nums, 1);
        int neg = BinarySearch(nums, 0);
        return pos > neg ? pos : neg;
    }

    public int BinarySearch(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == k) {
                while (mid - 1 >= 0 && nums[mid - 1] == k) {    //条件要满足顺序先验原则
                    mid--;
                }       //用于处理连续重复的数字
                return mid;
            } else if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        System.out.println(new Solution().maximumCount(nums));
    }
}
