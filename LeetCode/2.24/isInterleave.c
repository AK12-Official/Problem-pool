//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

//两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：


// 前i个 和 前j个
bool isInterleave(char *s1, char *s2, char *s3)
{
    int len1 = strlen(s1);
    int len2 = strlen(s2);
    int len3 = strlen(s3);


    if ((len1 + len2) != len3) {
        return false;
    }


    bool **dp = (bool **)malloc((len1 + 1) * sizeof(bool *));
    for (int i = 0; i <= len1; i++) {
        dp[i] = (bool *)malloc((len2 + 1) * sizeof(bool));
    }

    dp[0][0] = true;
    for (int i = 1; i <= len1; i++) {
        dp[i][0] = dp[i - 1][0] && (s1[i - 1] == s3[i - 1]);
    }
    for (int j = 1; j <= len2; j++) {
        dp[0][j] = dp[0][j - 1] && (s2[j - 1] == s3[j - 1]);
    }


    for (int i = 1; i <= len1; i++) {
        for (int j = 1; j <= len2; j++) {
            dp[i][j] = (dp[i - 1][j] && (s1[i - 1] == s3[i + j - 1])) ||
                       (dp[i][j - 1] && (s2[j - 1] == s3[i + j - 1]));
        }
    }


    bool result = dp[len1][len2];



    return result;
}

// dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符是否能交错组成 s3 的前 i + j 个字符。
// 通过填充这个二维数组，我们可以最终得到 dp[len1][len2]，即 s1 和 s2 是否能交错组成 s3


//想了半天dp能不能处理需要交替使用待选串的情况
//当然是可以的
//因为对前一个状态来说
//不管是基于s1还是s2完成的判断
//接下来都可以用另一个串或当前串来继续判断

//对于下面双指针的错误方法
//要考虑某个串不合要求之后回退并拿另一个串判断
//但是dp没有这个需要



// bool isInterleave(char* s1, char* s2, char* s3) {
//     int len1 = strlen(s1);
//     int len2 = strlen(s2);
//     int len3 = strlen(s3);

//     // 检查是否所有字符串都是空串
//     if (len1 == 0 && len2 == 0 && len3 == 0) {
//         return true;
//     }

//     // 检查 s1 和 s2 的长度之和是否等于 s3 的长度
//     if ((len1 + len2) != len3) {
//         return false;
//     }

//     // 如果 s1 为空，直接比较 s2 和 s3
//     if (len1 == 0) {
//         return strcmp(s2, s3) == 0;
//     }

//     // 如果 s2 为空，直接比较 s1 和 s3
//     if (len2 == 0) {
//         return strcmp(s1, s3) == 0;
//     }

//     int index1 = 0, index2 = 0;
//     bool WhichToBeginwith = false;
//     bool initialized = false;

//     if (s3[0] == s1[0]) {
//         WhichToBeginwith = true;
//         initialized = true;
//     }
//     if (s3[0] == s2[0]) {
//         WhichToBeginwith = false;
//         initialized = true;
//     }
//     if (!initialized) {
//         return false;
//     }

//     bool ans = true;
//     int count = 0;
//     for (int i = 0; i < len3; i++) {
//         if (WhichToBeginwith) {
//             if (s1[index1] == s3[i]) {
//                 index1++;
//             } else {
//                 i--;
//                 count++;
//                 WhichToBeginwith = !WhichToBeginwith;
//             }
//         } else {
//             if (s2[index2] == s3[i]) {
//                 index2++;
//             } else {
//                 i--;
//                 count++;
//                 WhichToBeginwith = !WhichToBeginwith;
//             }
//         }
//         if (count > len3) {
//             ans = false;
//             break;
//         }
//     }
//     return ans;
// }