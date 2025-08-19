这是一个很好的问题！让我详细解释为什么在二分查找中最后返回 `left` 就是正确的插入位置。

## 关键理解：循环不变量

在这个二分查找算法中，有一个重要的**循环不变量**：

- `left` 左边的所有元素都 **< target**
- `right` 右边的所有元素都 **≥ target**

## 详细分析

### 初始状态

```java
left = 0, right = nums.length - 1
```

- `left` 左边没有元素（空）
- `right` 右边没有元素（空）
- 循环不变量成立

### 循环过程中的状态维护

1. **当 `nums[mid] < target` 时**：

   ```java
   left = mid + 1;
   ```

   - 说明 `nums[mid]` 及其左边的所有元素都 < target
   - 更新后，`left` 左边的所有元素仍然 < target
2. **当 `nums[mid] > target` 时**：

   ```java
   right = mid - 1;
   ```

   - 说明 `nums[mid]` 及其右边的所有元素都 ≥ target
   - 更新后，`right` 右边的所有元素仍然 ≥ target
3. **当 `nums[mid] == target` 时**：

   ```java
   return mid;
   ```

   - 直接返回找到的位置

### 循环结束时的状态

当 `left > right` 时循环结束，此时：

- `left` 是第一个 ≥ target 的位置
- 这正是我们需要插入 target 的位置

## 具体例子

### 例子1：target 存在于数组中

```
nums = [1, 3, 5, 6], target = 5

初始: left=0, right=3
第1次: mid=1, nums[1]=3 < 5, left=2
第2次: mid=2, nums[2]=5 == 5, return 2
```

### 例子2：target 需要插入到中间

```
nums = [1, 3, 5, 6], target = 4

初始: left=0, right=3
第1次: mid=1, nums[1]=3 < 4, left=2
第2次: mid=2, nums[2]=5 > 4, right=1
第3次: left=2 > right=1, 循环结束

此时 left=2，正是 4 应该插入的位置：[1, 3, 4, 5, 6]
```

### 例子3：target 插入到开头

```
nums = [1, 3, 5, 6], target = 0

初始: left=0, right=3
第1次: mid=1, nums[1]=3 > 0, right=0
第2次: mid=0, nums[0]=1 > 0, right=-1
第3次: left=0 > right=-1, 循环结束

此时 left=0，正是 0 应该插入的位置：[0, 1, 3, 5, 6]
```

### 例子4：target 插入到末尾

```
nums = [1, 3, 5, 6], target = 7

初始: left=0, right=3
第1次: mid=1, nums[1]=3 < 7, left=2
第2次: mid=2, nums[2]=5 < 7, left=3
第3次: mid=3, nums[3]=6 < 7, left=4
第4次: left=4 > right=3, 循环结束

此时 left=4，正是 7 应该插入的位置：[1, 3, 5, 6, 7]
```

## 总结

返回 `left` 正确的原因是：

1. **循环不变量保证**：`left` 始终指向第一个应该 ≥ target 的位置
2. **边界处理完美**：无论 target 插入到开头、中间还是末尾，`left` 都能正确指示位置
3. **算法的本质**：我们实际上在寻找"第一个 ≥ target 的位置"，这正是插入位置的定义

这种技巧在很多二分查找的变种问题中都会用到，是一个非常重要的编程模式。
