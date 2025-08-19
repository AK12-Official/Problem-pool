
import java.util.Arrays;

class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long leftBound = BinarySearchForLowerBound(nums, lower - nums[i], i + 1);
            long rightBound = BinarySearchForUpperBound(nums, upper - nums[i], i + 1);

            if (leftBound <= rightBound) {
                ans += rightBound - leftBound + 1;
            }
        }

        return ans;
    }

    // 在 [startIndex, nums.length-1] 范围内查找第一个 >= target 的位置
    private long BinarySearchForLowerBound(int[] nums, int target, int startIndex) {
        int left = startIndex;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 在 [startIndex, nums.length-1] 范围内查找最后一个 <= target 的位置
    private long BinarySearchForUpperBound(int[] nums, int target, int startIndex) {
        int left = startIndex;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0};
        //System.out.println(new Solution().BinarySearchForUpperBound(nums, 6));
    }
}
//改进思路：
//只查找nums[0]得到一个限界
//后续迭代缩小限界
/*
public long countFairPairs(int[] nums, int lower, int upper) {
    Arrays.sort(nums);
    return countPairsLessEqual(nums, upper) - countPairsLessEqual(nums, lower - 1);
}

// 计算和 <= target 的配对数量
private long countPairsLessEqual(int[] nums, int target) {
    long count = 0;
    int left = 0, right = nums.length - 1;
    
    while (left < right) {
        if (nums[left] + nums[right] <= target) {
            // nums[left] 可以与 [left+1, right] 的所有元素配对
            count += right - left;
            left++;
        } else {
            right--;
        }
    }
    return count;
}*/
