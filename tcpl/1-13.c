#include <stdio.h>

#define IN 1
#define OUT 0

int main() {

    // restrict the number of input words
    int count = 0, max = 10;
    int container[max];
    int c, state = OUT;
    int len = 0;

    while ((c = getchar()) != EOF) {
        if (count == 10) {
            break;
        }
        if (c == ' ' || c == '\t' || c == '\n') {
            if (state == IN) {
                count++;
                for (int j = 0; j < len; j++) {
                    printf("=");
                }
                container[count] = len;                
                len = 0;
                printf("\n");
            }
            state = OUT;
        } else {
            len++;
            putchar(c);
            state = IN;
        }
    }
    
    printf("finish\n");
}
