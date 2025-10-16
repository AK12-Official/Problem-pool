
import java.util.Arrays;

class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        int max = 0;

        Arrays.sort(houses);
        Arrays.sort(heaters);
        max = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        
        int minR = 0;
        int maxR = max;
        int mid;

        while (minR < maxR) {
            mid = minR + (maxR - minR) / 2;
            if (check(houses, heaters, mid)) {
                maxR = mid;
            } else {
                minR = mid + 1;
            }
        }
        return minR;
    }

    private boolean Mycheck(int[] houses, int[] heaters, int k) {
        boolean ans;
        if (heaters.length == 1) {
            ans = heaters[0] - k <= houses[0] && heaters[0] + k >= houses[houses.length - 1];
            return ans;
        }
        int maxdiff = 0;
        for (int i = 1; i < heaters.length; i++) {
            maxdiff = heaters[i] - heaters[i - 1] - 1 > maxdiff ? heaters[i] - heaters[i - 1] - 1 : maxdiff;
        }
        ans = heaters[0] - k <= houses[0] && heaters[heaters.length - 1] + k >= houses[houses.length - 1] && 2 * k >= maxdiff;
        return ans;
    }
    //存在的问题：
    //对于像[1,2,3,5,15]，[2,30]这样的输入样例会给出错解
    //因为加热器的位置可能会出房屋很远，这样用maxdiff判断会带来错误

    private boolean check(int[] houses, int[] heaters, int k) {
        int n = houses.length, m = heaters.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 找到距离houses[i]最近的加热器
            while (j + 1 < m && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            if (Math.abs(heaters[j] - houses[i]) > k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] houses = new int[]{1, 5};
        int[] heaters = new int[]{10};
        System.out.println(new Solution().findRadius(houses, heaters));
    }

}
