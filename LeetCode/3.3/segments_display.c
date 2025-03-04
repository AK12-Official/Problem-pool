#include <stdio.h>
#include <string.h>

void draw_segments(int a, int b, int c, int d, int e, int f, int g) {
    printf("\033[2J\033[H"); // 清屏并定位光标
    printf(" %c \n", a ? '_' : ' ');
    printf("%c%c%c\n", f ? '|' : ' ', g ? '_' : ' ', b ? '|' : ' ');
    printf("%c%c%c\n", e ? '|' : ' ', d ? '_' : ' ', c ? '|' : ' ');
    fflush(stdout);
}

int main() {
    setvbuf(stdin, NULL, _IOLBF, 0);
    char line[256];
    while (fgets(line, sizeof(line), stdin)) {
        int a=0, b=0, c=0, d=0, e=0, f=0, g=0;
        fprintf(stderr, "Read line: %s", line); // 添加调试信息
        char *token = strtok(line, " ");
        while (token) {
            char seg;
            int val;
            if (sscanf(token, "%c=%d", &seg, &val) == 2) {
                switch(seg) {
                    case 'A': a = val; break;
                    case 'B': b = val; break;
                    case 'C': c = val; break;
                    case 'D': d = val; break;
                    case 'E': e = val; break;
                    case 'F': f = val; break;
                    case 'G': g = val; break;
                }
            }
            token = strtok(NULL, " ");
        }
        draw_segments(a, b, c, d, e, f, g);
    }
    return 0;
}