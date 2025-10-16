
class Solution {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int len = points.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int temp = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            max = Math.max(temp, max);
        }

        int left = 0;
        int right = max + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(points, s, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return getPoints(points, left);
    }

    private boolean check(int[][] points, String s, int mid) {
        char[] S = s.toCharArray();
        int len = points.length;
        boolean[] record = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (Math.max(Math.abs(points[i][0]), Math.abs(points[i][1])) <= mid) {   //在正方形中
                if (record[S[i] - 'a']) {
                    return false;
                } else {
                    record[S[i] - 'a'] = true;
                }
            }
        }
        return true;
    }

    private int getPoints(int[][] points, int right) {
        int ans = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            if (Math.max(Math.abs(points[i][0]), Math.abs(points[i][1])) <= right) {   //在正方形中
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}};
        String s="abdca";
        System.out.println(new Solution().maxPointsInsideSquare(points, s)+"            114514");
    }
}
