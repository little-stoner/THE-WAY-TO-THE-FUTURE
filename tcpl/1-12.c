#include <stdio.h>

#define IN 1
#define OUT 0

int main() {

    int c;
    int state = OUT;
    while((c = getchar()) != EOF) {
        if (c == ' ' || c == '\t' || c == '\n') {
            if (state == IN) {
                printf("\n");                
            }
            state = OUT;
        }
        else {
            state = IN;
        }
        if (state == IN) {
            putchar(c);
        }
    }
    printf("\n");

}

void m() {
    int c, lastc, state;
    state = OUT;
    while ((c = getchar()) != EOF) {
        if (c == ' ' || c == '\n' || c == '\t') {
            state = OUT;
            if (lastc != ' ' && lastc != '\n' && lastc != '\t') {
                putchar('\n');
            }
        } else {
            state = IN;
            if (lastc == '\n') {
                putchar('\n')
            }
            putchar(c);
        }
    }
}
