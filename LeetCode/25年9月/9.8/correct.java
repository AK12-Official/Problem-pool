
class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxT = 0;
        for (int t : workerTimes) {
            maxT = Math.max(maxT, t);
        }
        int h = (mountainHeight - 1) / workerTimes.length + 1;
        long left = 0;
        long right = (long) maxT * h * (h + 1) / 2;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(long m, int leftH, int[] workerTimes) {
        for (int t : workerTimes) {
            //先除再乘避免溢出
            leftH -= ((int) Math.sqrt(m / t * 8 + 1) - 1) / 2;
            if (leftH <= 0) {
                return true;
            }
        }
        return false;
    }
}
