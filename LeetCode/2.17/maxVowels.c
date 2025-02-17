int maxVowels(char* s, int k) {
    int len=strlen(s);

    int num=0;
    for(int i=0;i<k;i++){
        if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u')
        num++;
    }

    int ans=num;
    for(int i=0;i<len-k;i++){
        if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u')
        num--;
        if(s[i+k]=='a'||s[i+k]=='e'||s[i+k]=='i'||s[i+k]=='o'||s[i+k]=='u')
        num++;

        ans=ans>num?ans:num;
    }
    return ans;


}