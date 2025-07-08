// 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。

// 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。

class Solution {
    public int maxScore(String s) {

        int leftZeros = 0;
        int rightOnes = 0;
        int maxScore = 0;
        // 计算初始右子字符串中 1 的数量
        for (char c : s.toCharArray()) {
            if (c == '1') {
                rightOnes++;
            }
        }

        // 遍历每一个可能的分割点
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            int currentScore = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}

//天才！
//先假设分割点在第一个字符前 即 整个字符串为右子字符串
//先保存整个字符串中1的个数
//然后遍历字符串 假设当前字符为分割点 当前得分＝左子字符串中0的个数+右子字符串中1的个数
//最大得分就是一个变化量 最后会停在最大值