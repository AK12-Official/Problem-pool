
import java.util.Arrays;

class Solution {

    public int maxPossibleScore(int[] start, int d) {
        int len = start.length;
        Arrays.sort(start);

        int left = 0;
        int right = start[len - 1] - start[0] + d + 1;
        int mid;
        while (left + 1 < right) {
            //left 1
            //right 0
            mid = left + (right - left) / 2;
            if (check(start, d, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] start, int d, int mid) {
        int len = start.length;
        int[] copy = start.clone();
        for (int i = 1; i < len; i++) {
            if (copy[i] + d >= copy[i - 1] + mid) {
                copy[i] = copy[i] > copy[i - 1] + mid ? copy[i] : copy[i - 1] + mid;
            } else {
                return false;
            }
        }
        return true;
    }

}
// 假设答案是 x。我们可以通过排序来找到一个有效的整数配置，起始值应该是 start[0]，然后每一个后续的整数应该是 [start[i], start[i] + d] 中大于 last_chosen_value + x 的最小值。

class SolutionPro {

    public int maxPossibleScore(int[] start, int d) {
        int len = start.length;
        Arrays.sort(start);

        // 使用long防止溢出
        long left = 0;
        long right = (long) start[len - 1] - start[0] + d + 1;
        long mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (check(start, d, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }

    private boolean check(int[] start, int d, long mid) {
        int len = start.length;
        long prev = start[0];
        for (int i = 1; i < len; i++) {
            long minNext = prev + mid;
            long maxNext = (long) start[i] + d;
            if (maxNext < minNext) {
                return false;
            }
            prev = Math.max(minNext, start[i]);
        }
        return true;
    }

}
