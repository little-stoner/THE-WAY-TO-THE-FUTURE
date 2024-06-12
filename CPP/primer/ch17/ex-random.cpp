//
// Created by viber on 2023/10/19.
//

#include <iostream>
#include <random>

int main() {

    std::default_random_engine e; // generates random unsigned integers
    for (size_t i = 0; i < 10; ++i)
        // e() "calls" the object to produce the next random number
        std::cout << e() << " ";


    // uniformly distributed from 0 to 9 inclusive
    std::uniform_int_distribution<unsigned> u(0,9);
    std::default_random_engine ee; // generates unsigned random integers
    for (size_t i = 0; i < 10; ++i)
        // u uses e as a source of numbers
        // each call returns a uniformly distributed value in the specified range
        std::cout << u(ee) << " ";

    std::cout << std::endl;

    return 0;
}

