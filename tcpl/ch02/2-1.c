//
// Created by viber on 2023/1/27.
//

#include <stdio.h>
#include <limits.h>

int main() {


    printf(" char max: %d, char min: %d\n", CHAR_MAX, CHAR_MIN);
    unsigned char a;
    printf(" unsigned char a: %d\n", a);
    signed char aa;
    aa = -1;
    printf(" signed char aa: %d\n", aa);

    printf("++++++++++++++++++++++++++++++++++++++++++++++\n");

    printf(" short max: %d, short min: %d\n", SHRT_MAX, SHRT_MIN);
    unsigned short b;
    signed short bb;


    printf(" int max: %d, int min: %d\n", INT_MAX, INT_MIN);
    unsigned int c;
    signed int cc;


    printf(" long max: %ld, long min: %ld\n", LONG_MAX, LONG_MIN);
    unsigned long d;
    signed long dd;

    return 0;
}

