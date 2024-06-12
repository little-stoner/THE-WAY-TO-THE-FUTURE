//
// Created by viber on 2023/9/29.
//

#include <iostream>

int main() {
    int sum = 0, value = 0;
    while (std::cin >> value) {
        sum += value;
    }
    std::cout << " Sum is : " << sum << std::endl;
    return 0;
}
