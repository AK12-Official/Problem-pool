
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > arr.length / 4) {
                return arr[i];
            }
        }
        return -1; //should not reach here
    }

    public int findSpecialIntegerPlus(int[] arr) {
        int n = arr.length;
        int[] candidates = {arr[n / 4], arr[n / 2], arr[3 * n / 4], arr[0]};
        for (int num : candidates) {
            int first = lowerBound(arr, num);
            int last = upperBound(arr, num);
            if (last - first > n / 4) {
                return num;
            }
        }
        return -1;
    }

    // 返回第一个>=target的下标
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1; 
            }else {
                right = mid;
            }
        }
        return left;
    }

    // 返回第一个>target的下标
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1; 
            }else {
                right = mid;
            }
        }
        return left;
    }
}
