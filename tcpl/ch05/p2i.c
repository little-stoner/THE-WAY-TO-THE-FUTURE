//
// Created by viber on 2023/2/11.
//

#include <stdio.h>

void swap(int x, int y) {
    int temp = x;
    x = y;
    y = temp;
}
void swap0(int *x, int *y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}

int main() {
    int x = 1, y = 2, z[10];
    int *ip;

    ip = &x;
    printf(">>>>>> ip: %p\n", ip);
    y = *ip;
    printf(">>>>>> y: %d\n", y);

    *ip = 0;
    printf(">>>>>> x: %d\n", x);

    ip = &z[0];
    printf(">>>>>> *ip: %d\n", *ip);
    printf(">>>>>> ip: %p\n", ip);



    return 0;
}



