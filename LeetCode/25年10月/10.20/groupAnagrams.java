import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String Strkey = str2Key(str);
            // map.getOrDefault(Strkey, new ArrayList<>()).add(str);
            map.computeIfAbsent(Strkey, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String str2Key(String str) {
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}