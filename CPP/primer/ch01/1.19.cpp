//
// Created by viber on 2023/9/30.
//

#include <iostream>

int main() {

    int v1 = 0, v2 = 0;
    std::cin >> v1 >> v2;

    if (v1 < v2) {
        std::cout << " v1 " << v1 << " is less than v2 " << v2 << std::endl;
        return 0;
    }

    // range closed
    while (v1 <= v2) {
        std::cout << " v: " << v1 << std::endl;
        ++v1;
    }

    return 0;
}

