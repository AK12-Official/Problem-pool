
class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] - 'a' <= target - 'a') {
            return letters[0];
        }

        int left = 0;
        int right = letters.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                while (letters[mid + 1] == target) {
                    mid ++;
                }
                return letters[mid + 1];
            } else if (letters[mid] - 'a' > target - 'a') {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return letters[mid + 1];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        Solution sln = new Solution();
        System.out.println(sln.nextGreatestLetter(letters, 'e'));
    }
}
//恶心谁呢塞个几把eeeeeeeennnn来