// class Solution {
//     public int[][] generateMatrix(int n) {
//         int total = n * n;
//         int[][] result = new int[n][n];

//         int numOfCircle = n / 2;

//         int count = 1;

//         for (int i = 0; i <= numOfCircle; i++) {
//             // 从起点开始
//             int x = i, y = i;
//             int step = (n - 1) - 2 * i;

//             result[x][y] = count;
//             count++;
//             // 向右
//             for (int j = 0; j < step; j++) {
//                 if (count > total)
//                     break;
//                 y++;
//                 result[x][y] = count;
//                 count++;
//             }
//             // 向下
//             for (int j = 0; j < step; j++) {
//                 if (count > total)
//                     break;
//                 x++;
//                 result[x][y] = count;
//                 count++;
//             }
//             // 向左
//             for (int j = 0; j < step; j++) {
//                 if (count > total)
//                     break;
//                 y--;
//                 result[x][y] = count;
//                 count++;
//             }
//             // 向上
//             for (int j = 0; j < step - 1; j++) {
//                 if (count > total)
//                     break;
//                 x--;
//                 result[x][y] = count;
//                 count++;
//             }
//             if (count > total)
//                 break;
//         }

//         return result;
//     }
// }

class Solution {
    public int[][] generateMatrix(int n) {
        int total = n * n;
        int[][] result = new int[n][n];

        int count = 1;
        int x = 0, y = 0; // 起始位置
        int step = n; // 初始步长

        while (count <= total) {
            // 向右
            for (int i = 0; i < step; i++) {
                result[x][y++] = count++;
            }
            y--;
            x++;
            step--; // 调整位置和步长

            // 向下
            for (int i = 0; i < step; i++) {
                result[x++][y] = count++;
            }
            x--;
            y--; // 调整位置

            // 向左
            for (int i = 0; i < step; i++) {
                result[x][y--] = count++;
            }
            y++;
            x--;
            step--; // 调整位置和步长

            // 向上
            for (int i = 0; i < step; i++) {
                result[x--][y] = count++;
            }
            x++;
            y++; // 调整位置
        }

        return result;
    }
}

class Main {

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int n = 5;

        int[][] result = s1.generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }
}