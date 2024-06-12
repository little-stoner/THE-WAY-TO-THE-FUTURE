//
// Created by viber on 2023/9/29.
//

#include <iostream>

int main() {
    int sum = 0;
    for (int i = -100; i <= 100; ++i) {
        sum += i;
    }
    std::cout << "sum : " << sum << std::endl;
    return 0;
}
