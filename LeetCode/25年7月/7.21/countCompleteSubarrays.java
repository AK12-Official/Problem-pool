
class Solution {

    public int countCompleteSubarrays(int[] nums) {

        int diff = Scan(nums);

        int left = 0, right = 0;
        int ans = 0;
        int[] record = new int[2000];
        for (right = 0; right < nums.length; right++) {
            if (record[nums[right] - 1] == 0) {
                diff--;
            }
            record[nums[right] - 1]++;
            while (diff == 0) {
                record[nums[left] - 1]--;
                if (record[nums[left] - 1] == 0) {
                    diff++;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }

    private int Scan(int[] nums) {
        int[] result = new int[2000];
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (result[nums[i] - 1] == 0) {
                result[nums[i] - 1]++;
                ret++;
            }
        }
        return ret;
    }
}
