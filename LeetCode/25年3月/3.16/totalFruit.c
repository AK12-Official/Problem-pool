#include <stdio.h>
#include <stdlib.h>

int totalFruit(int* fruits, int fruitsSize) {
    int* count = (int*)calloc(fruitsSize, sizeof(int));
    int left = 0, right = 0, maxLen = 0, uniqueCount = 0;

    while (right < fruitsSize) {
        if (count[fruits[right]] == 0) {
            uniqueCount++;
        }
        count[fruits[right]]++;
        right++;

        while (uniqueCount > 2) {
            count[fruits[left]]--;
            if (count[fruits[left]] == 0) {
                uniqueCount--;
            }
            left++;
        }

        if (right - left > maxLen) {
            maxLen = right - left;
        }
    }

    free(count);
    return maxLen;
}