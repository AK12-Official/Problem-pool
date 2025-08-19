
import java.util.Arrays;

class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] Q = new int[queries.length];
        int[] W = new int[words.length];

        for (int idx = 0; idx < queries.length; idx++) {
            Q[idx] = functionn(queries[idx]);
        }
        for (int idx = 0; idx < words.length; idx++) {
            W[idx] = functionn(words[idx]);
        }

        Arrays.sort(W);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = words.length - BinarySearch(W, Q[i]);
        }
        return ans;
    }

    private int functionn(String s) {
        int[] times = new int[26];
        char[] S = s.toCharArray();
        for (int i = 0; i < S.length; i++) {
            times[S[i] - 'a']++;
        }
        int i = 0;
        while (times[i] == 0) {
            i++;
        }
        return times[i];
    }

    private int BinarySearch(int[] words, int queries) {
        int left = 0;
        int right = words.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (words[mid] <= queries) {
                left = mid + 1;     //left左侧一定<=queries
            } else {
                right = mid;
            }
        }
        return left;    //返回words中小于queries
    }
}

//在Arrays.sort的lambda表达式上卡了一手
//因为比较器接收的是对象 int数组是基本数据类型 无法被比较器处理
