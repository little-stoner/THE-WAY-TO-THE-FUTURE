//
// Created by viber on 2023/10/13.
//

#include <iostream>
#include <string>
#include <memory>
#include <vector>

int main() {

    std::allocator<std::string> alloc; // object that can allocate strings
    auto const p = alloc.allocate(9);// allocate n unconstructed strings

    auto q = p; // q will point to one past the last constructed element
    alloc.construct(q++); // *q is the empty string
    alloc.construct(q++, 10, 'c'); // *q is cccccccccc
    alloc.construct(q++, "hi"); // *q is hi!

    return 0;
}

