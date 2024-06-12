//
// Created by viber on 2023/9/29.
//

#include <iostream>

int main() {
    //
    int sum = 0;
    for (int val = 50; val <= 100; ++val) {
        sum += val;
        ++val;
    }
    std::cout << " Sum of 50 to 100 inclusive is "
              << sum << std::endl;
    //
    for (int val = 10; val >=0; --val) {
        std::cout << " val: " << val << std::endl;
    }
    return 0;
}
