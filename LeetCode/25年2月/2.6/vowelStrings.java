class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int ans=0;

        boolean Begin(String str){
            return str.startsWith('a')||str.startsWith('e')||str.startsWith('i')||str.startsWith('o')||str.startsWith('u');
        };
        boolean End(String str){
            return str.endsWith('a')||str.endsWith('e')||str.endsWith('i')||str.endsWith('o')||str.endsWith('u');
        };


        for(int i=left;i<right;i++){
            String str=words[i];
            if(str.Begin()&&str.End())
            ans++;
        }
        return ans;
    }
}