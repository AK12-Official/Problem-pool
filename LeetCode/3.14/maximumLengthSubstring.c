#include <stdio.h>
#include <stdlib.h>

int maximumLengthSubstring(char* s) {
    int has[128]={0};
    int left=0,ans=0;

    for(int right=0;s[right];right++){
        char c=s[right];
        has[c]++;
        //要把has[c]的执行放在while循环的前面，因为如果放在后面，当has[c]>2时，left已经加1了，这样就会导致has[c]的值不准确  
        while(has[c]>2){
            has[s[left]]--;
            left++;
        }
        ans=ans>right-left+1?ans:right-left+1;
    }
    return ans;
}


int main() {
    char s[] = "bcbbbcba";
    printf("%d\n", maximumLengthSubstring(s));
    return 0;
}