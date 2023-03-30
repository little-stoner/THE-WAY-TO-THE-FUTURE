#include <stdio.h>

void squeese(char s1[], char s2[]);

int main() {
    char a[] = "abababb";
    squeese(a, "aaaa");
    return 0;
}

void squeese(char s1[], char s2[]) {

    int i, j, match;
    for (i = 0, j = 0; s1[i] != '\0'; ++i) {
        char c = s1[i];
        match = 0;
        for (int k = 0; s2[k] != '\0'; ++k) {
            if (s2[k] == c) {
                match = 1;
            }
        }
        if (!match) {
            s1[j++] = s1[i];
        }
    }
    s1[j] = '\0';

    printf("%s", s1);
    printf("\n");
    
}
