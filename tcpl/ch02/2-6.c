#include <stdio.h>

int setbits(int x, int p, int n, int y);

int main() {

}

int setbits(int x, int p, int n, int y) {
    return ((x >> (p+1-n)) << n) | (y & ~(~0 << n));
}












