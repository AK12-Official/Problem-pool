
import java.util.*;

class SnapshotArray {

    private int snapId;
    Map<Integer, List<int[]>> history;

    public SnapshotArray(int length) {
        this.history = new HashMap<>();
        this.snapId = 0;

        for (int i = 0; i < length; i++) {
            history.put(i, new ArrayList<>());
            history.get(i).add(new int[]{-1, 0}); // snap_id=-1, value=0
        }
    }

    public void set(int index, int val) {
        history.computeIfAbsent(index, k -> new ArrayList()).add(new int[]{snapId, val});
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> ls = history.get(index);

        int left = 0;
        int right = ls.size();
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (ls.get(mid)[0] > snap_id) { 
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return ls.get(left - 1)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */
//对循环不变量的分析越来越娴熟了 快速判断出了二分算法最终给出的是哪个量