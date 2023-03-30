#include <stdio.h>

void squeese(char s1[], char s2[]);

int main() {
    char a[] = "abababb";
    squeese(a, "aaaa");
    return 0;
}

void squeese(char s1[], char s2[]) {

    int i = 0, j = 0;
    while (s1[i++] != '\0') {}
    while (s2[j++] != '\0') {}

    printf(">>> %s \n", s1);
    
    for (int n = 0; n < i; n++) {
        for(int m = 0; m < j; m++) {
            if (s1[n] == s2[m]) {
                s1[n] = '\0';
            }
        }
    }

    for (int k = 0; k < i; k++) {
        printf("%c", s1[k]);
    }
    printf("\n");
    
}
