class Solution {

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessEqual(m, n, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }//countLessEqual(left-1)<k  countLessEqual(right)>=k
    //结合countLessEqual返回值跳变的特性 最后一定会收敛到某个表中数字处
    

    // 统计乘法表中 <= mid 的数的个数
    private int countLessEqual(int m, int n, int mid) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, mid / i);
        }
        return count;
    }

    //countLessEqual的返回值是离散的 只有当mid为表中某个值的时候才会发生跳变
    //以3*3的表为例，对于mid输入为6，7，8 会返回同一个结果，当mid=9才跳变
    //如果输入k=8，那么查询会不断迭代缩小上界最终到6

    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(3, 3, 8)+"   123");
    }
}
