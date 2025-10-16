
class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long minSeconds = 1;
        long maxSeconds = (long) 1e14;

        long mid;
        while (minSeconds < maxSeconds) {
            mid = minSeconds + (maxSeconds - minSeconds) / 2;
            if (getHeight(workerTimes, mid) >= mountainHeight) {
                maxSeconds = mid;
            } else {
                minSeconds = mid + 1;
            }
        }
        return minSeconds;
    }

    // 计算所有工人在time秒内最多能挖多少米
    private long getHeight(int[] arr, long time) {
        long ans = 0;
        //中间的乘积导致了溢出
        for (int i = 0; i < arr.length; i++) {
            double a = arr[i];
            // 解一元二次方程，避免溢出
            double delta = 1 + 8.0 * time / a;
            long x = (long) ((-1 + Math.sqrt(delta)) / 2);
            ans += x;
        }
        return ans;
    }

}
