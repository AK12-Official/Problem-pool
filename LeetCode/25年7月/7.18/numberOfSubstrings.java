
class Solution {

    public int numberOfSubstrings(String s, int k) {
        char[] S = s.toCharArray();
        int[] count = new int[26];

        int left = 0, right = 0;
        int ans = 0;

        for (right = 0; right < S.length; right++) {
            count[S[right] - 'a']++;
            while (count[S[right] - 'a']==k) {
                count[S[left] - 'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }

    boolean havek(int k,int[] nums){
        for(int i :nums){
            if(i>=k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s="abacb";
        int k=2;
        Solution sln=new Solution();

        System.out.println(sln.numberOfSubstrings(s, k));
    }
}
