
class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(matrix, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    // 统计矩阵中 <= mid 的数的个数
    private int count(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = n - 1, col = 0;
        int cnt = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                cnt += row + 1; // 这一列从0到row都 <= mid
                col++;
            } else {
                row--;
            }
        }
        return cnt;
    }

    //爬楼梯统计 O(n)
}
