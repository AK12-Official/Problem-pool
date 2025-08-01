
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int beautifulBouquet(int[] flowers, int cnt) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;
        for (int right = 0; right < flowers.length; right++) {
            map.put(flowers[right], map.getOrDefault(flowers[right], 0) + 1);

            while (map.get(flowers[right]) > cnt) {
                map.put(flowers[left], map.get(flowers[left]) - 1);
                left++;
            }

            ans += (right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] flowers = new int[]{1, 2, 3, 2};
        int cnt = 1;

        System.out.println(new Solution().beautifulBouquet(flowers, cnt));
    }
}
