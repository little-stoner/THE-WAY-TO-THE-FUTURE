
#include <stdio.h>


int add_int(int n, int m);

int main() {

    int (*function_ptr)(int, int);
    function_ptr = &add_int;

    int r = function_ptr(1, 2);

    printf(">>> %d\n", r);
        
    return 0;
}

int add_int(int n, int m) {
    return n + m;
}
