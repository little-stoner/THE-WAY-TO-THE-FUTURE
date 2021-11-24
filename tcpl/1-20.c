#include <stdio.h>

#define TAB 8

int main() {

    int c;
    int count = 0;
    while ((c = getchar()) != EOF) {

        if (c == '\t') {
            int span = TAB - count % TAB;
            for (int i=0; i < span; i++) {
                printf("0");
            }
            count += span;
        } else {
            putchar(c);
            count++;
        }
        
    }
    printf("\n");
    return 0;
    
}
