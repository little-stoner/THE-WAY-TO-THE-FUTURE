//
// Created by viber on 2023/10/13.
//


#include <iostream>
#include <string>
#include <memory>
#include <vector>

int main() {
    // call get_size to determine how many ints to allocate
    int *pia = new int[get_size()]; // pia points to the first of these ints
    typedef int arrT[42]; // arrT names the type array of 42 ints
    int *p = new arrT; // allocates an array of 42 ints ; p points to the first one


    int *pia = new int[10]; //     block of ten uninitialized ints
    int *pia2 = new int[10](); // block of ten ints value initialized to 0
    string *psa = new string[10]; //block of ten empty strings
    string *psa2 = new string[10]();// block of ten empty strings

    // block of ten ints each initialized from the corresponding initializer
    int *pia3 = new int[10]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    // block of ten strings; the first four are initialized from the given initializers
    // remaining elements are value initialized
    string *psa3 = new string[10]{"a", "an", "the", string(3, 'x')};

    //
    // up points to an array of ten uninitialized ints
    unique_ptr<int[]> up(new int[10]);
    up.release(); // automatically uses delete[] to destroy its pointer

    //
    // to use a shared_ptr we must supply a deleter
    shared_ptr<int> sp(new int[10], [](int *p) { delete[] p; });
    sp.reset(); // uses the lambda we supplied that uses delete[] to free the array


    return 0;

}

