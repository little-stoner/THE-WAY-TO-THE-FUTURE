#include <stdio.h>

int htoi(char s[]);

int main() {
    printf(" ==> %d \n", htoi("Oxa"));
    printf(" ==> %d \n", htoi("OxF"));    
}


int htoi(char s[]) {    
    char t = s[2];
    if (t >= '0' && t <= '9') {
        return t - '0';
    }
    else if (t >= 'a' && t <= 'f') {
        return 9 + (t - 'a' + 1);
    }
    else if (t >= 'A' && t <= 'F') {
        return 9 + (t - 'A' + 1);
    }
    return 0;
}
