
class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = max > piles[i] ? max : piles[i];
        }

        int maxSpeed = max;
        int minSpeed = 1;
        int mid;
        while (minSpeed < maxSpeed) {
            mid = minSpeed + (maxSpeed - minSpeed) / 2;
            if (getTime(piles, mid) <= h) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return maxSpeed;
    }

    private int getTime(int[] arr, int k) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) {
                ret += arr[i] / k;
                if(arr[i]%k>0){
                    ret++;
                }
            } else {
                ret++;
            }
        }
        return ret;
    }
}
