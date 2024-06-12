//
// Created by viber on 2023/10/10.
//

#include <iostream>
#include <array>
#include <string>

void error_msg(std::initializer_list<std::string> il) {
    for (auto beg = il.begin(); beg != il.end(); ++beg)
        std::cout << *beg << " ";
    std::cout << std::endl;
}

void swap(int &v1, int &v2) {
    // if the values are already the same, no need to swap, just return
    if (v1 == v2)
        return;
    // if we’re here, there’s work to do
    int tmp = v2;
    v2 = v1;
    v1 = tmp;
    // no explicit return necessary
}

char &get_val(std::string &str, std::string::size_type ix) {
    return str[ix]; // get_val assumes the given index is valid
}

int factorial(int val) {
    if (val > 1)
        return factorial(val - 1) * val;
    return 1;
}

int odd[] = {1, 3, 5, 7, 9};
int even[] = {0, 2, 4, 6, 8};

// returns a pointer to an array of five int elements
decltype(odd) *arrPtr(int i) {
    return (i % 2) ? &odd : &even; // returns a pointer to the array
}


int main(int argc, char *argv[]) {
    std::string s("a value");
    std::cout << s << std::endl; // prints a value
    get_val(s, 0) = 'A';// changes s[0] to A
    std::cout << s << std::endl; // prints A value
    return 0;
}