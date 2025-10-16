
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int minimumCardPickup(int[] cards) {
        int len = cards.length;

        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(cards[i])) {
                //更新ans
                if (ans == -1) {
                    ans = i - map.get(cards[i]) + 1;
                } else {
                    ans = ans > i - map.get(cards[i]) + 1 ? i - map.get(cards[i]) + 1 : ans;
                }
            }
            //更新最近的kv记录
            map.put(cards[i], i);
        }
        return ans;

    }
}
