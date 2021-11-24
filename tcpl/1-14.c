#include <stdio.h>

int main() {

    char container[128];
    int c;
    for (int i = 0; i < 128; i++) {
        container[i] = 0;
    }
    
    while ((c = getchar()) != EOF) {
        container[c] = container[c] + 1;
    }

    printf(">>>>>>>>>>>>>>");
    int count;
    for (int i = 0; i < 128; i++) {
        count = container[i];
        if(count == 0) continue;
        putchar(i);
        if (i == '\n') { printf("newline: "); }
        if (i == ' ') { printf("space: "); }
        for (int j = 0; j < count; j++) {
            printf("=");
        }
        printf("\n");
    }
    
}
