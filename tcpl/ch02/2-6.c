#include <stdio.h>

int setbits(int x, int p, int n, int y);

int main() {

    
    
}

int setbits(int x, int p, int n, int y) {

    int a = (x >> p) << (p - n + 1);

    int b = (~(~0 << n) & y);

    int c = (~(~0 << n) & x);
    
    return ((a & c) << n) & c;
}












