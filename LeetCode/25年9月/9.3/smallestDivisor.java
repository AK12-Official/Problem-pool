
class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = nums[i] > max ? nums[i] : max;
        }

        int mid;
        //超时      目的是最小化除数
        while (min < max) {
            mid = min + (max - min) / 2;
            if (getSum(nums, mid) <= threshold) {
                max = mid;  //当前除数可行 可以继续缩小
            } else {
                min = mid + 1;  //当前除数不可行，需要放大
            }
        }
        return min;
    }

    private int getSum(int[] arr, int d) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += (arr[i] + d - 1) / d;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{21212, 10101, 12121};
        System.out.println(" " + new Solution().smallestDivisor(nums, 1000000));
    }
}
