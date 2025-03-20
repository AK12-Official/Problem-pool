#include <stdio.h>
#include <string.h>

int BruteForceStringMatch(char *text, char *pattern)
{
    int n = strlen(text);
    int m = strlen(pattern);

    for (int i = 0; i <= n - m; i++)    //为什么等于： 考虑最末端才能匹配成功  i+m=n 从（下标为i）第i+1个字符开始匹配 是左闭区间
    { // n-m  优化
        
        int j;
        for (j = 0; j < m; j++)
        {
            if (pattern[j] != text[i + j])
            {
                break;
            }
        }
        if(j==m){
            return i;
        }

        // 错误写法
        // 这么写跳过了对最后一个字符的检查
        //  if(pattern[j]==text[i+j]){
        //      continue;
        //  }else{
        //      if(j==m-1){
        //          return i;
        //      }
        //      break;
        //  }
    }

    return -1;
}

int main()
{
    char text[] = "ababcabcacbab";
    char pattern[] = "abcac";
    int result = BruteForceStringMatch(text, pattern);
    printf("result=%d\n", result);
    return 0;
}