
#include <stdio.h>

int main() {

    
    
}

void lower(char s[]) {

    int i = 0, c;
    while((c = s[i]) != '\0') {
        if (c > 'A' && c < 'Z') {
            
        }
        s[i] = c > 'A' && c < 'Z' ? c + 40 : c;
        i++;
    }
    
}
