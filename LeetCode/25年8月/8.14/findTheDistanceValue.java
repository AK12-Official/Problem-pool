import java.util.Arrays;

class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;

        for (int i = 0; i < arr1.length; i++) {
            int leftBound = BinarySearch(arr2, arr1[i] - d);   // 第一个 >= (x-d) 的位置
            int rightBound = BinarySearch(arr2, arr1[i] + d + 1); // 第一个 >= (x+d+1) 的位置

            if (leftBound == rightBound) {
                ans++;  // 区间 [x-d, x+d] 内没有元素
            }
        }
        return ans;
    }


    private int BinarySearch(int[] arr, int d) {
        int left = 0;
        int right = arr.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= d) {  // 改为 >=
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-3, 10, 2, 8, 0, 10};
        int[] arr2 = new int[]{-9, -1, -4, -9, -8};
        //-9 -9 -8 -4 -1
        int d = 9;
        System.out.println(new Solution().findTheDistanceValue(arr1, arr2, d));
        System.out.println(new Solution().BinarySearch(arr2, 8+9));

    }
}
// x - d <= y <= x + d

//很迷茫
//de了半天bug不知道在de什么
//感觉二分是没有问题的
//主程序的逻辑有误
//一开始找 >= 的位置是正确的
//后来改的找 > 的二分函数也是正确的
//只是找 > 的话无法很好的处理边界情况

//比如main中的例子
// 找 > 的话 ，在BinarySearch(arr2, 8-9)，返回位置5
// 这个返回值当然是正确的 但是无法去处理最后那个 arr2[4]==-1
// 实践发现如果判断 BinarySearch(arr2, 8-9)==arr2.length 再去进一步判断arr2最后一个元素的效果不好 但我不排除这个方案可行
// 找 >= 的位置，BinarySearch(arr2, 8-9)，返回位置4
// 再去找到BinarySearch(arr2, 8+9+1)的位置，返回位置是5
// 说明[8-9,8+9]存在元素