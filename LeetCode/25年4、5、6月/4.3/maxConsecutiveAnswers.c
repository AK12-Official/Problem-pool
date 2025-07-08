#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int maxConsecutiveAnswers(char *answerKey, int k)
{
    int left = 0;
    int len = strlen(answerKey);
    int right = 0;

    int ret = 0;
    int current_T = 0;
    int current_F = 0;
    int current_len = 0;

    for (right = 0; right < len; right++)
    {

        if (answerKey[right] == 'T')
            current_T++;
        current_len = right - left + 1;
        current_F = current_len - current_T;

        int temp = current_T > current_F ? current_T : current_F;

        // 缩小窗口
        while (temp + k < current_len)
        {
            if (answerKey[left] == 'T')
                current_T--;
            else
                current_F--;
            left++;
            current_len = right - left + 1;
            temp = current_T > current_F ? current_T : current_F;
        }

        ret = ret > current_len ? ret : current_len;
    }
    return ret;
}

int main()
{
    char *answerKey = "FFTFTTTFFF";
    int k = 1;
    int result = maxConsecutiveAnswers(answerKey, k);
    printf("Result: %d\n", result); // Expected output: 4
    return 0;
}