
class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum == target) {
            return nums.length;
        }

        int times = target / sum;
        target = target % sum;

        int left = 0, right;
        int cnt = 0;
        int len = Integer.MAX_VALUE;
        for (right = 0; right < 2 * nums.length - 1; right++) {
            cnt += nums[right % nums.length];

            while (cnt >= target) {
                if (cnt == target) {
                    len = len < right - left + 1 ? len : right - left + 1;
                }
                cnt -= nums[left % nums.length];
                left++;
            }
        }

        if (len == Integer.MAX_VALUE) {
            return -1;
        } else {
            return times * nums.length + len;
        }
    }
}


//重生之我是调试高手