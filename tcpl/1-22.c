#include <stdio.h>

#define COL 5

int main() {

    int c;
    int count = 0;
    char last;
    while ((c = getchar()) != EOF) {
        if (count == COL) {
            count = 0;
            printf("\n");
        } else {
            putchar(c);
            count++;
            if (c == ' ' || c == '\t') {
            
            } else {
                last = c;
            }
        }
    }
    
}
