
class Solution {

    public long repairCars(int[] ranks, int cars) {
        int len = ranks.length;
        int minR = ranks[0];
        for (int i = 0; i < len; i++) {
            minR = Math.min(minR, ranks[i]);
        }

        long minTime = 0;
        long maxTime = (long) minR * cars * cars;
        long mid;

        while (minTime + 1 < maxTime) {
            mid = minTime + (maxTime - minTime) / 2;
            long repairedCars = 0;
            for (int i = 0; i < ranks.length; i++) {
                repairedCars += Math.sqrt(mid / ranks[i]);
            }
            if (repairedCars >= cars) {
                maxTime = mid; // 满足要求
            } else {
                minTime = mid;
            }
        }
        return maxTime;
    }

}
