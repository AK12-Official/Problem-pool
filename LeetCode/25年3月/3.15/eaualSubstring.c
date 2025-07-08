int equalSubstring(char* s, char* t, int maxCost) {
    int realCost=0;

    int left=0,right=0;
    int ans=0;

    for(right;s[right];right++){
        realCost+=abs(s[right]-t[right]);
        while(realCost>maxCost){
            realCost-=abs(s[left]-t[left]);
            left++;
        }
        ans=ans>right-left+1?ans:right-left+1;
    }
    return ans;
}