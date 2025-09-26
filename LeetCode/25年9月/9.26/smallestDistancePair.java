
import java.util.Arrays;

class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int count(int[] nums, int mid) {
        int n = nums.length;
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
    //最开始的写法是计算那个元素开始和第一个元素差值大于mid，基于数组有序的特性中间的对差值一定小于该元素和第一个元素的差，直接计算该区间内所有的对
    //但是这个算法有误 无法处理 1 99 100 mid=50这样的输入 ，因为就像上面提到的，“中间的对差值一定小于该元素和第一个元素的差”，但是这个差值和mid没有直接的关联

    public static void main(String[] args) {
        System.out.println(new Solution().smallestDistancePair(new int[]{1, 3, 1}, 1) + "    finish");
    }
}
