#include <stdio.h>
#include <math.h>

int htoi(char s[]);

int main() {
    printf(" ==> %d \n", htoi("Oxaa"));
    printf(" ==> %d \n", htoi("OxF"));    
}


int htoi(char s[]) {    
    int n, len = 0;
    char c;
    while (s[len] != '\0') {
        len++;
    }
    for (int j = len-1; j > len - 3 ; --j) {
        c = s[j];
        int x = pow(16, len-1 - j);
        if (c >= 'A' && c <= 'F') {
            n = (c - '7') * x;
        }
        if (c >= 'a' && c <= 'f') {
            n = (c - 'W') * x;
        }
        if (c >= '0' && c <= '9') {
            n = (c - '0') * x;
        }
    }
    return n;
}

int power(int base, int n) {
    int i, p;
    p = 1;
    for (i = 1; i <= n; ++i) {
        p = p * base;
    }
    return p;
}