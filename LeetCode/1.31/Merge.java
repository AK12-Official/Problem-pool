
// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

// 作者：LeetCode
// 链接：https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class MergeSolution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the start time
        // for(int i=0;i<intervals.length;i++){
        // for(int j=i+1;j<intervals.length;j++){
        // if(intervals[i][0]>intervals[j][0]){
        // int temp = intervals[i][0];
        // intervals[i][0] = intervals[j][0];
        // intervals[j][0] = temp;
        // temp = intervals[i][1];
        // intervals[i][1] = intervals[j][1];
        // intervals[j][1] = temp;
        // }
        // }
        // }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // Merge the intervals
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] { start, end });
        return list.toArray(new int[list.size()][]);

    }
}

// 选择某个区间做基准，如果后面的区间的start小于等于基准的end，那么就合并，否则就把基准加入到结果集中，然后更新基准
// 算是非常简单的思路了 就是实现稍微繁琐一点