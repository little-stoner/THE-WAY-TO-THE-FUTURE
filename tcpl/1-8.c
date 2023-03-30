#include <stdio.h>

int main() {

    int c;
    printf(" >>> c: %d", c);

    int newline = 0;
    int blank = 0;
    int tab = 0;
    while((c = getchar()) != EOF) {
        if (c == '\n') {
            ++newline;
        }
        if (c == ' ') {
            ++blank;
        }
        if (c == '\t') {
            ++tab;
        }
    }
    printf("nl: %d, blank: %d, tab: %d\n", newline, blank, tab);
    
}
