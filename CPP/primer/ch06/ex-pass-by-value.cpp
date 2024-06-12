//
// Created by viber on 2023/10/10.
//

#include <iostream>

// function that takes a pointer and sets the pointed-to value to zero
void reset(int *ip) {
    *ip = 0; // changes the value of the object to which ip points
    ip = 0; // changes only the local copy of ip; the argument is unchanged
}

int main() {

    int n = 0;  // ordinary variable of type int
    int i = n; // i is a copy of the value in n
    i = 42; // value in i is changed; n is unchanged

    n = 0, i = 42;
    int *p = &n, *q = &i; // p points to n;q points to i
    *p = 42; // value in n is changed;p is unchanged
    p = q; // p now points to i; values in i and n are unchanged

    i = 42;
    reset(&i); // changes i but not the address of i
    std::cout << "i=" << i << std::endl; // prints i=0

    return 0;
}

