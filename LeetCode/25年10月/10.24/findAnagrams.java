import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        p = SortedString(p);
        List<Integer> ans = new ArrayList<>();
        for (int left = 0; left < s.length() - p.length() + 1; left++) {
            String str = s.substring(left, left + p.length());
            str = SortedString(str);
            if (str.equals(p)) {
                ans.add(left);
            }
        }
        return ans;

    }

    private String SortedString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}