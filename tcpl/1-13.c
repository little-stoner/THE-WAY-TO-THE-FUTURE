#include <stdio.h>

#define IN 1
#define OUT 0

void histogram_horizontal();
void vertical();

int main() {
    vertical();
}

int main0() {

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

    return 0;
}

void histogram_horizontal() {
    int c, state, wl;
    wl = 0;
    int MAX = 100;
    char bar[MAX];
    for (int i=0; i < MAX; ++i) {
        bar[i] = ' ';
    }

    state = OUT;

    while ((c = getchar()) != EOF) {
        if (c == ' ' || c == '\t' || c == '\n') {
            if (state == IN) {
                printf(" : ");
                for (int i=0; i < wl; ++i) {
                    printf("%c", bar[i]);
                }
                printf("\n");
            }
            state = OUT;
            wl = 0;
        }
        else if (state == OUT) {
            state = IN;
        }
        if (state == IN) {
            bar[wl++] = '*';
            putchar(c);
        }
    }
}

void vertical() {
    int c, state, wc, wl;
    wc = 0, wl = 0;
    int MAX = 100;
    int bar[MAX];
    for (int i = 0; i < MAX; ++i) {
        bar[i] = 0;
    }

    state = OUT;

    while ((c = getchar()) != EOF) {
        if (c == ' ' || c == '\t' || c == '\n') {
            state = OUT;
            bar[wc] = wl;
            wl = 0;
        }
        else if (state == OUT) {
            state = IN;
        }
        if (state == IN) {
            wl++;
            wc++;
            // putchar(c);
        }
    }

    printf("==============\n");

    int max_len = 0;
    for (int i = 0; i < wc; ++i) {
        int len = bar[i];
        if (len > max_len) {
            max_len = len;
        }
    }

    int j = 0;
    while (j < max_len) {
        for (int i = 0; i < wc; ++i) {
            int len = bar[i];
            if (len > j) {
                printf("*");
            } else {
                printf(" ");
            }
        }
        printf("\n");
        j++;
    }

}