
import java.util.Arrays;

// class RangeFreqQuery {
//     private int[] arr;
//     public RangeFreqQuery(int[] arr) {
//         this.arr = arr;
//     }
//     public int query(int left, int right, int value) {
//         int[] tempArr = new int[right - left + 1];      //数组范围修改 要+1
//         for (int i = 0; i < tempArr.length; i++) {
//             tempArr[i] = this.arr[left + i];
//         }
//         Arrays.sort(tempArr);
//         int ans = BinarySearch(tempArr, value + 1) - BinarySearch(tempArr, value);
//         return ans;
//     }
//     private int BinarySearch(int[] nums, int value) {
//         int left = 0;
//         int right = nums.length;
//         int mid;
//         while (left < right) {
//             mid = left + (right - left) / 2;
//             if (nums[mid] < value) {
//                 left = mid + 1;         //left左侧一定小于value
//             } else {
//                 right = mid;
//             }
//         }
//         return left;
//     }
//     //这个算法肯定是正确的 
//     //但是性能比较差劲
//     //换个思路 去存储每个值的下标
// }
/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr); int param_1 =
 * obj.query(left,right,value);
 */
// class RangeFreqQuery {
//     private Map<Integer, List<Integer>> valueToIndices;
//     public RangeFreqQuery(int[] arr) {
//         valueToIndices = new HashMap<>();
//         for (int i = 0; i < arr.length; i++) {
//             valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
//         }
//     }
//     public int query(int left, int right, int value) {
//         if (!valueToIndices.containsKey(value)) {
//             return 0;
//         }
//         List<Integer> indices = valueToIndices.get(value);
//         int leftBound = lowerBound(indices, left);
//         int rightBound = upperBound(indices, right);
//         return rightBound - leftBound;
//     }
//     private int lowerBound(List<Integer> list, int target) {
//         int left = 0, right = list.size();
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (list.get(mid) < target) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }
//         return left;
//     }
//     private int upperBound(List<Integer> list, int target) {
//         int left = 0, right = list.size();
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (list.get(mid) <= target) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }
//         return left;
//     }
// }

