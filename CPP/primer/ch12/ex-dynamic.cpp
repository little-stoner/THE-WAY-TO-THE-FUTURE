//
// Created by viber on 2023/10/13.
//

#include <iostream>
#include <string>
#include <vector>
#include <list>
#include <memory>

int main() {

    std::shared_ptr<std::string> p1; // shared_ptr that can point at a string

    std::shared_ptr<std::list<int>> p2; // shared_ptr that can point at a list of ints

    // if p1 is not null, check whether it’s the empty string
    if (p1 && p1->empty())
        *p1 = "hi"; // if so, dereference p1 to assign a new value to that string
    std::shared_ptr<int> p3 = std::make_shared<int>(42);
    std::shared_ptr<std::string> p4 = std::make_shared<std::string>(10, '9');
    std::shared_ptr<int> p5 = std::make_shared<int>();
    auto p6 = std::make_shared<std::vector<std::string>>();
    //
    auto p = std::make_shared<int>(42); // object to which p points has one user
    auto q(p); // p and q point to the same object
               // object to which p and q point has two users


    //
    return 0;
}

