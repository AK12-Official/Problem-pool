
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /**
     * @param nums 要被做查询的数组
     * @param queries 要查询的元素的下标
     * @return 每个nums[queries[i]]和最近的等值元素的循环距离
     */
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList();

        Map<Integer, List<Integer>> NumberAndIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            NumberAndIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int value = Search(NumberAndIndex, nums[queries[i]], queries[i], nums.length);
            ans.add(value);
        }
        return ans;
    }

    /**
     * @param map 处理得到的原数组nums的 value-indexSet
     * @param target 要查找的值
     * @param queries 要查找的原始元素在nums数组中的下标（对应 queries[i]）
     * @param Arraylength nums数组的长度，用于计算循环距离
     * @return 要查找的nums[queries[i]]和最近等值元素的循环距离
     */
    private int Search(Map<Integer, List<Integer>> map, int target, int queries, int ArrayLength) {
        List<Integer> list = map.get(target);

        if (list.size() == 1) {
            return -1;
        }
        int Index = BinarySearch(list, queries); //要查找的nums[queries[i]]在其出现列表中的下标
        // 找到前一个和后一个位置（循环）
        int preIndex = (Index - 1 + list.size()) % list.size();
        int aftIndex = (Index + 1) % list.size();

        int pre = list.get(preIndex);
        int aft = list.get(aftIndex);

        // 计算循环距离 要么正着要么倒着 两个距离是互补的
        int distToPre = Math.min(Math.abs(queries - pre), ArrayLength - Math.abs(queries - pre));
        int distToAft = Math.min(Math.abs(queries - aft), ArrayLength - Math.abs(queries - aft));

        return Math.min(distToPre, distToAft);
    }

    /**
     * @param list 某个nums中元素的下标列表
     * @param queries 要查找的value
     * @return queries在list中的下标
     */
    private int BinarySearch(List<Integer> list, int queries) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < queries) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
