//
// Created by viber on 2023/10/10.
//

#include <iostream>
#include <string>
#include <vector>

void print(const char *cp) {
    if (cp) // if cp is not a null pointer
        while (*cp) // so long as the character it points to is not a null character
            std::cout << *cp++; // print the character and advance the pointer
}

void print(const int *beg, const int *end) {
    // print every element starting at beg up to but not including end
    while (beg != end)
        std::cout << *beg++ << std::endl; // print the current element
    // and advance the pointer
}

// const int ia[] is equivalent to const int* ia
// size is passed explicitly and used to control access to elements of ia
void print(const int ia[], size_t size) {
    for (size_t i = 0; i != size; ++i) {
        std::cout << ia[i] << std::endl;
    }
}

// ok: parameter is a reference to an array; the dimension is part of the type
void print(int (&arr)[10]) {
    for (auto elem : arr)
        std::cout << elem << std::endl;
}
//
void print(int (*matrix)[10], int rowSize) {}
void printx(int matrix[][10], int rowSize) {}

int main(int argc, char *argv[]) {

    int j[2] = {0, 1};

    print(std::begin(j), std::end(j));

    return 0;
}

