
class Solution {

    public int balancedString(String s) {
        int n = s.length();
        char[] S = s.toCharArray();
        int cntQ = 0;
        int cntW = 0;
        int cntE = 0;
        int cntR = 0;

        for (char i : S) {
            switch (i) {
                case 'Q':
                    cntQ++;
                    break;
                case 'W':
                    cntW++;
                    break;
                case 'E':
                    cntE++;
                    break;
                case 'R':
                    cntR++;
                    break;
            }
        }
        //已平衡返回0；
        if (cntQ == (n / 4) && cntW == (n / 4) && cntE == (n / 4) && cntR == (n / 4)) {
            return 0;
        }

        int left = 0, right = 0;
        int len = n;
        int Threshold = n / 4;

        for (right = 0; right < n; right++) {
            switch (S[right]) {
                case 'Q':
                    cntQ--;
                    break;
                case 'W':
                    cntW--;
                    break;
                case 'E':
                    cntE--;
                    break;
                case 'R':
                    cntR--;
                    break;
            }
            while (cntQ <= Threshold && cntW <= Threshold && cntE <= Threshold && cntR <= Threshold) {
                len = len < right - left + 1 ? len : right - left + 1;
                switch (S[left]) {
                    case 'Q':
                        cntQ++;
                        break;
                    case 'W':
                        cntW++;
                        break;
                    case 'E':
                        cntE++;
                        break;
                    case 'R':
                        cntR++;
                        break;
                }
                left++;
            }
        }
        return len;
    }
}
