
class Solution {

    public long minimumTime(int[] time, int totalTrips) {
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < time.length; i++) {
            max = max > time[i] ? max : time[i];
        }

        long left = 0;
        long right = max * totalTrips;
        long ans = right;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (getTrips(time, mid) >= totalTrips) {
                //能够完成 降低上限
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long getTrips(int[] arr, long k) {
        long trips = 0;
        for (int i = 0; i < arr.length; i++) {
            trips += k / arr[i];
        }
        return trips;
    }
}
