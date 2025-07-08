//48----57
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int numDecodings(char* s) {
    int len=strlen(s);

    int dp[len+1];
    dp[0]=1;
    if(s[0]!='0'){
        dp[1]=1;
    }else{
        dp[1]=0;
    }

    for(int i=2;i<=len;i++){
        int before=(int)(s[i-2])-48;
        int now=(int)(s[i-1])-48;
        if(now==0){
            //不能单独解码 
            if(before==1||before==2){
                dp[i]=dp[i-2];  //能配合上一位解码
            }else{
                dp[i]=0;        //不能配合上一位解码
            }
        }else{
            //能单独解码
            if(before==1||(before==2&&now<=6)){
                dp[i]=dp[i-1]+dp[i-2];  //能配合上一位解码
            }else{
                dp[i]=dp[i-1];          //不能配合上一位解码
            }
        }
    }
    return dp[len];
}

int main(){
    char s[]="2101";
    printf("%d\n",numDecodings(s));
    return 0;
}