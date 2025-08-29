
import java.util.*;
import java.util.stream.Stream;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //left是第一个>=x的元素的下标
        int leftBound = left - k;
        int rightBound = left;
        while (leftBound < 0) {
            leftBound++;
            rightBound++;
        }
        while (true) {
            //对比leftBound和righeBound
            if (rightBound == arr.length) {
                break;
            }

            if (x - arr[leftBound] <= arr[rightBound] - x) {
                break;
            }
            leftBound++;
            rightBound++;
        }
        List ans = new ArrayList();
        for (int i = leftBound; i < rightBound; i++) {
            ans.add(arr[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 6, 7, 8, 9, 11, 13};
        System.out.println(new Solution().findClosestElements(arr, 0, 9));
    }
}
