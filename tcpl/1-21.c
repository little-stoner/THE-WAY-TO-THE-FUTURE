#include <stdio.h>
#define TAB 8
#define IN 1
#define OUT 0

int main0() {

    int pos = 0;
    int c, state = OUT;
    int span = 0;
    while ((c = getchar()) != EOF) {
        if (c == ' ' || c == '\t') {
            if (state == IN) {
                if (c == ' ') span++;
                if (c == '\t') span += TAB;
            } else {
                state = IN;
                if (c == ' ') span++;
                if (c == '\t') span += TAB;                
            }
        } else {
            if (state == IN) {
                int r = TAB - pos % TAB;
                //printf(">>>>>> span: %d, r: %d, post: %d\n", span, r, pos);
                if (span >= r) {
                    printf("-");
                    for (int i=0; i < (span - r); i++) {
                        printf("0");
                    }
                } else {
                    for (int i=0; i < span; i++) {
                        printf("0");
                    }
                }
                state = OUT;
                pos += span;
                span = 0;
            }
            putchar(c);
        }
        if (state == OUT) pos++;
    }
    
    return 0;
}

int main() {
    int c, span;
    int wc = 0;
    while ((c = getchar()) != EOF) {
        if (c == '\t') {
            span = TAB - wc % TAB;
            for (int i = 0; i < span; ++i) {
                putchar('*');
            }
            wc += span;
        } else {
            wc++;
            putchar(c);
        }
    }
}