//
// Created by viber on 2023/10/8.
//

#include <iostream>

int main() {

    // static_cast

    int i, j;
    double slope = i/j;
    // cast used to force floating-point division
    double slope = static_cast<double>(j) / i;

    void* p = &d; // ok: address of any non const object can be stored in a void*
                  // ok: converts void* back to the original pointer type
    double *dp = static_cast<double*>(p);

    const char *pc;
    char *p = const_cast<char*>(pc);// ok: but writing through p is undefined

    int *ip;
    char *pc = reinterpret_cast<char*>(ip);



    return 0;
}

