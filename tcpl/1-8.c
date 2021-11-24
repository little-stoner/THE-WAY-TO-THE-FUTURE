#include <stdio.h>

int main() {

    int c, num;
    num = 0;
    while((c = getchar()) != EOF && c != '\n') {
        printf(">>>>>>>>>\n");
        if (c == '\n' || c == ' ' || c == '\t') {
            num++;
        }
    }
    printf("%d\n", num);
    
}
