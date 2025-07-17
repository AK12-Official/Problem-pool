
class Solution {

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = num > max ? num : max;
        }

        int left = 0, right = 0;
        long ans=0;
        for (right = 0; right < n; right++) {
            if(nums[right]==max){
                k--;
            }

            while(k<=0){
                if(nums[left]==max){
                    k++;
                }
                left++;
            }
            ans+=left;
        }
        return ans;
    }
}
