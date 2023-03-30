//
// Created by viber on 2023/1/28.
//

int invert(int x, int p, int n) {
    return ((x >> (p+1-n)) << n) | ~(x & ~(~0 << n));
}
