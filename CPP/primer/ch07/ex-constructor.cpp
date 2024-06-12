//
// Created by viber on 2023/10/12.
//

#include <iostream>
#include <string>
#include <vector>


class ConstRef {
public:
    ConstRef(int ii);

private:
    int i;
    const int ci;
    int &ri;
};

/**
// error: ci and ri must be initialized
ConstRef::ConstRef(int ii) { // assignments:
    i = ii; // ok
    ci = ii; // error: cannot assign to a const
    ri = i; // error: ri was never initialized
}
 */
// ok:explicitly initialize reference and const members
ConstRef::ConstRef(int ii): i(ii), ci(ii), ri(i) { }

int main() {
    std::string foo = "Hello World!"; // define and initialize
    std::string bar; // default initialized to the empty string
    bar = "Hello World!"; // assign a new value to bar

    return 0;
}
