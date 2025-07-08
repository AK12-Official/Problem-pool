class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum=0;
        long currentSum=0;
        Map<Integer,Integer>countMap=new HashMap();

        for(int i=0;i<nums.length;i++){
            if(i>=k){
                currentSum -= nums[i-k];
                countMap.put(nums[i-k], countMap.get(nums[i-k]) - 1);
                if (countMap.get(nums[i-k]) == 0) {
                    countMap.remove(nums[i-k]);
                }
            }
            currentSum += nums[i];
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1 && countMap.size() >= k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}