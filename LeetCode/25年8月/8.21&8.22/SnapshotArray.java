
import java.util.*;

class SnapshotArray {

    private int snapId;
    private Map<Integer, List<int[]>> history;

    public SnapshotArray(int length) {
        history = new HashMap<>();
        snapId = 0;

        for (int i = 0; i < length; i++) {
            history.put(i, new ArrayList<>());
            history.get(i).add(new int[]{-1, 0}); // snap_id=-1, value=0
        }
    }

    public void set(int index, int val) {
        List<int[]> indexHistory = history.get(index);

        // 如果当前快照已经有记录，更新；否则添加新记录
        if (!indexHistory.isEmpty() && indexHistory.get(indexHistory.size() - 1)[0] == snapId) {
            indexHistory.get(indexHistory.size() - 1)[1] = val;
        } else {
            indexHistory.add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> indexHistory = history.get(index);

        // 二分查找最后一个 snap_id <= target_snap_id 的记录
        int left = 0, right = indexHistory.size() - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (indexHistory.get(mid)[0] <= snap_id) {
                result = indexHistory.get(mid)[1];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */
// 实现支持下列接口的「快照数组」- SnapshotArray：
// SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
// void set(index, val) - 会将指定索引 index 处的元素设置为 val。
// int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
// int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
