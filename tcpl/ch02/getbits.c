//
// Created by viber on 2023/1/28.
//

unsigned getbits(unsigned x int p, int n) {
    return (x >> (p+1-n)) & ~(~0 << n);
}
