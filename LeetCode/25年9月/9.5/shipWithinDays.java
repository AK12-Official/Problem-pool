
class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            maxWeight = maxWeight > weights[i] ? maxWeight : weights[i];
            sum += weights[i];
        }

        int maxCapcity = sum;
        int minCapcity = maxWeight;

        int mid;
        while (minCapcity < maxCapcity) {
            mid = minCapcity + (maxCapcity - minCapcity) / 2;
            if (getDays(weights, mid) <= days) {
                //可行 继续降低上界
                maxCapcity = mid;
            } else {
                minCapcity = mid + 1;
            }
        }
        return maxCapcity;
    }

    private int getDays(int[] arr, int k) {
        int load = 0;
        int days = 0;
        for (int i = 0; i < arr.length; i++) {
            load += arr[i];
            if (load > k) {
                load = 0;
                i--;
                days++;
            }
        }
        return load == 0 ? days : days + 1;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("" + new Solution().shipWithinDays(weights, 5));
    }
}
