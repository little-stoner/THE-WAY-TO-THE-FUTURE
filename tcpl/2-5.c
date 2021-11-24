#include <stdio.h>



int main() {
    
}

int any(char s1[], char s2[]) {

    int p = 0;    
    int i = 0, j = 0;
    
    while (s1[i++] != '\0') {}
    while (s2[j++] != '\0') {}

    int flag = 0;
    for (int m = 0; m < i; m++) {
        for (int n = 0; n < j; n++) {
            if (s1[m] == s2[n]) {
                p = n;
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            break;
        }
    }
    if (flag == 0) return -1;
    return p;
    
}
