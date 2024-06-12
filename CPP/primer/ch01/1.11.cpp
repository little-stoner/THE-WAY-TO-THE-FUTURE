//
// Created by viber on 2023/9/29.
//

#include <iostream>

int main() {
    int v1 = 0, v2 = 0;
    std::cin >> v1 >> v2;

    // range closed
    while (v1 <= v2) {
        std::cout << " v: " << v1 << std::endl;
        ++v1;
    }

    return 0;
}