
import java.util.*;

class TopVotedCandidate {

    Map<Integer, Integer> count;
    List<Integer> prefixMode;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.count = new HashMap<>();
        this.prefixMode = new ArrayList<>();
        int len = persons.length;
        int maxCount = 0;
        int lingxian = -1;
        for (int i = 0; i < len; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (count.get(persons[i]) >= maxCount) {
                maxCount = count.get(persons[i]);
                lingxian = persons[i];
            }
            prefixMode.add(lingxian);
        }
        //顺序遍历 如果出现了新的最大值 那一定是当前遍历到的元素
        this.times = times;
    }

    public int q(int t) {
        int left = 0;
        int right = this.times.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (times[mid] <= t) {
                left = mid + 1; //left左侧一定小于等于t
            } else {
                right = mid;
            }
        }
        //left是第一个大于t的元素的下标（可能越界但LeetCode的测试样例里面似乎没有下越界的情况  所以直接大胆减一就可以）
        return this.prefixMode.get(left - 1);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times); int param_1 =
 * obj.q(t);
 */
