#include <stdio.h>

int main() {

    int c, d;
    
    while((c = getchar()) != EOF && c != '\n') {
        putchar(c);
        if ((c = getchar()) != ' ') {
            putchar(c);
        }
    }

    printf("\n");
    
}
