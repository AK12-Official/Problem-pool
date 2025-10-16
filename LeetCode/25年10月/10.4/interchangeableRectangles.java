
import java.util.HashMap;
import java.util.Map;

class Solution {

    public long interchangeableRectangles(int[][] rectangles) {
        int len = rectangles.length;

        Map<String, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int gcd = gcd(rectangles[i][0], rectangles[i][1]);
            String key = (rectangles[i][0] / gcd) + "/" + (rectangles[i][1] / gcd);
            if (map.containsKey(key)) {
                ans += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().interchangeableRectangles(new int[][]{{4, 5}, {7, 8}}));
    }
}
