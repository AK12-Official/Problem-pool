
import java.util.Arrays;

class Solution {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int len = increase.length;

        int[] CivilizationLevel = new int[len + 1];
        int[] Resouces = new int[len + 1];
        int[] Human = new int[len + 1];

        for (int i = 1; i < len + 1; i++) {
            CivilizationLevel[i] = increase[i - 1][0] + CivilizationLevel[i - 1];
            Resouces[i] = increase[i - 1][1] + Resouces[i - 1];
            Human[i] = increase[i - 1][2] + Human[i - 1];
        }

        int len2 = requirements.length;
        int[] ans = new int[len2];
        for (int i = 0; i < len2; i++) {
            int CDay = BinarySearch(CivilizationLevel, requirements[i][0]);
            int RDay = BinarySearch(Resouces, requirements[i][1]);
            int HDay = BinarySearch(Human, requirements[i][2]);
            int day = Math.max(CDay, Math.max(RDay, HDay));
            ans[i] = (day > len) ? -1 : day;
        }

        return ans;
    }

    //返回第一个>=key的元素的下标
    private int BinarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] increase = new int[][]{{1, 1, 1}};
        int[][] requirements = new int[][]{{1, 1, 1}};

        System.out.print(Arrays.toString(new Solution().getTriggerTime(increase, requirements)));

        System.out.println("\n程序运行结束");

    }
}

//去看了下题目
//剧情在第几天触发就返回几
//所以111 111这个输入应该返回1
//111 000 这个输入应该返回0，这是细节上的处理
