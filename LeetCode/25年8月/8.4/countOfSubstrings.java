
class Solution {

    public static void main(String[] args) {
        Solution sln = new Solution();
        String word = "ieaouqqieaouqq";
        int k = 1;
        System.out.println(sln.countOfSubstrings(word, k));
    }

    public long countOfSubstrings(String word, int k) {
        return count(word, k) - count(word, k - 1);
    }

    public long count(String word, int k) {
        char[] Word = word.toCharArray();
        int[] count = new int[5];
        int Types = 0;
        int consonants = 0;

        int left = 0;
        long ans = 0;
        for (int right = 0; right < Word.length; right++) {
            if (isVowel(Word[right])) {
                int index = vowelToIndex(Word[right]);
                if (count[index] == 0) {
                    Types++;
                }
                count[index]++;
            } else {
                consonants++;
            }

            while (Types == 5 && consonants > k) {
                if (isVowel(Word[left])) {
                    int index = vowelToIndex(Word[left]);
                    count[index]--;
                    if (count[index] == 0) {
                        Types--;
                    }
                } else {
                    consonants--;
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private int vowelToIndex(char c) {
        switch (c) {
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case 'o':
                return 3;
            case 'u':
                return 4;
            default:
                return -1; // 不应该到达这里
        }
    }
}
