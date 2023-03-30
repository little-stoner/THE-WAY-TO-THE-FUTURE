#include <stdio.h>

#define IN 1
#define OUT 0

void t();

int main() {
    t();

}
int main0() {

    int c;
    int state;
    
    while((c = getchar()) != EOF) {
        if (c == ' ') {
            state = IN;
        } else {
            if (state == IN) {
                putchar(' ');
            }
            state = OUT;
            putchar(c);
        }
    }

    printf("\n");
    
}

void t() {
    int c, lastc;
    while((c = getchar()) != EOF) {
        if (c != ' ')
            putchar(c);
        if (c == ' ' && lastc != ' ')
            putchar(c);
        lastc = c;
    }
}