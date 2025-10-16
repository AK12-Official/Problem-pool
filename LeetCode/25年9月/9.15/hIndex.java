
import java.util.Collection;
import java.util.Collections;

class Solution {

    public int hIndex(int[] citations) {

        int left = 0;
        int right = 1000;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, citations)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean check(int mid, int[] nums) {
        if (mid > nums.length) {
            return false;
        }

        int count = 0;
        for (int citation : nums) {
            if (citation >= mid) {
                count++;
            }
        }
        return count >= mid;
    }
}
