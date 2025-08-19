class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 查找左边界（第一个 >= target 的位置）
        int leftBound = findLeftBound(nums, target);
        // 查找右边界（第一个 > target 的位置）
        int rightBound = findLeftBound(nums, target + 1);
        
        // 检查目标值是否存在
        if (leftBound < nums.length && nums[leftBound] == target) {
            result[0] = leftBound;
            result[1] = rightBound - 1;
        }
        
        return result;
    }
    
    // 查找第一个 >= target 的位置
    private int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;    //防溢出处理
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}

//和恰好型窗口类似的思路
//要学着去灵活转化问题
