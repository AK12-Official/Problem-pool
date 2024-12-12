// 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

// 如果可以，返回 true ；否则返回 false 。

// magazine 中的每个字符只能在 ransomNote 中使用一次。

#include <stdbool.h>
bool canConstruct(char *ransomNote, char *magazine)
{
    int r = strlen(ransomNote);
    int m = strlen(magazine);
    if (m < r)
        return false;
    int chart[26] = {0};
    for (int i = 0; i < m; i++)
    {
        chart[magazine[i] - 'a']++;
    }
    for (int i = 0; i < r; i++)
    {
        chart[ransomNote[i] - 'a']--;
    }
    for (int i = 0; i < 26; i++)
    {
        if (chart[i] < 0)
            return false;
    }
    return true;
}