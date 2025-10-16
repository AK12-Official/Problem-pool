
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] d : dominoes) {
            int key = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            int cnt = map.getOrDefault(key, 0);
            ans += cnt;
            map.put(key, cnt + 1);
        }
        return ans;
    }
}

//题目中有提到
// 1 <= dominoes[i][j] <= 9
//可以利用这个特性编码
