#include <stdio.h>
#include <unistd.h>

int segments[10][7] = {
    // A,B,C,D,E,F,G
    {1, 1, 1, 1, 1, 1, 0}, // 0
    {0, 1, 1, 0, 0, 0, 0}, // 1
    {1, 1, 0, 1, 1, 0, 1}, // 2
    {1, 1, 1, 1, 0, 0, 1}, // 3
    {0, 1, 1, 0, 0, 1, 1}, // 4
    {1, 0, 1, 1, 0, 1, 1}, // 5
    {1, 0, 1, 1, 1, 1, 1}, // 6
    {1, 1, 1, 0, 0, 0, 0}, // 7
    {1, 1, 1, 1, 1, 1, 1}, // 8
    {1, 1, 1, 1, 0, 1, 1}  // 9
};

int main()
{
    setvbuf(stdout, NULL, _IONBF, 0); // 无缓冲输出
    
    while (1)
    {
        
        for (int i = 0; i < 10; i++)
        {
            printf("A=%d B=%d C=%d D=%d E=%d F=%d G=%d\n",
                   segments[i][0], segments[i][1],
                   segments[i][2], segments[i][3],
                   segments[i][4], segments[i][5],
                   segments[i][6]);
            fflush(stdout);
            sleep(1);
        }
    }
    return 0;
}