#include <stdio.h>
#include <math.h>

int main() {
    //1, 2~7, 8~19, 20~37, 38~61, 62~
    //1,  +6,  +12,   +18,   +24, +30, +36, ... 
    int N, range = 1, i;
    scanf("%d", &N);
    for (i = 1; i; i++) {
        if (N <= range) break;
        range += i * 6;
    }
    printf("%d", i);
    return 0;
}