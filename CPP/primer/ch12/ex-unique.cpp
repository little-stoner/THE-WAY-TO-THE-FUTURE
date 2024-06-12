//
// Created by viber on 2023/10/13.
//

#include <iostream>
#include <string>
#include <memory>
#include <vector>

int main() {
    std::unique_ptr<double> p1; // unique_ptr that can point at a double
    std::unique_ptr<int> p2(new int(42)); // p2 points to int with value 42
    std::unique_ptr<std::string> p11(new std::string("Stegosaurus"));
    // std::unique_ptr<std::string> p22(p11); // error: no copy for unique_ptr
    std::unique_ptr<std::string> p3;
    // p3 = p2; // error: no assign for unique_ptr
}
