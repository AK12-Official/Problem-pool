
class Solution {

    public long countSubarrays(int[] nums, long k) {
        long mark;
        long ans = 0;
        int left = 0;
        long sum = 0;       //mark和sum都需要long

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            mark = sum * (right - left + 1);

            while (mark >= k) {
                sum -= nums[left];
                left++;
                mark = sum * (right - left + 1);
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sln = new Solution();
        int[] nums = new int[]{1, 1, 1};
        int k = 5;

        System.out.println(sln.countSubarrays(nums, k));
    }
}
