#include <stdio.h>

#define IN 1
#define OUT 0

int main() {

    int max = 10;
    int container[max];
    int c, state = OUT;
    int maxLen = 0;
    int len = 0;
    int counter = 0;

    while ((c = getchar()) != EOF) {
        if (counter > 10) break;
        if (c == ' ' || c == '\t' || c == '\n') {
            if (state == IN) {
                container[counter++] = len;
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 0;
                printf(" | ");
            }
            state = OUT;
        } else {
            len++;
            putchar(c);
            state = IN;
        }
    }
    printf("\n");
    for (int k = 0; k < counter; k++) {
        printf(" >>> %d ", container[k]);
    }
    printf("\n");

    for (int i = 0; i < maxLen; i++) {
        for (int j = 0; j < counter; j++) {
            if (container[j] > 0) {
                printf(" x  ");
                container[j] = container[j] - 1;                
            } else {
                printf("    ");
            }
        }
        printf("\n");
    }
    
}



