// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

// 请必须使用时间复杂度为 O(log n) 的算法。




int searchInsert(int* nums, int numsSize, int target) {
    if(target>nums[numsSize-1]) return numsSize;
    int index=(numsSize-1)/2;
    int low=0;
    int high=numsSize-1;
    while(true){
        if(nums[index]==target){
            return index;
        }
        if(nums[index]<target){
            low=index;
            index=(low+high)/2;
        }
        if(nums[index]>target){
            high=index;
            index=(low+high)/2;
        }
        if(low==index){
            if(target>nums[index])
            return index+1;
            else
            return index;
        }
    }
}