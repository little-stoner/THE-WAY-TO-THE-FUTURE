//
// Created by viber on 2022/9/21.
//

#include <vector>
#include <iostream>

int main() {
    std::vector<int> v1;
    std::cout << v1.size() << std::endl;
    for (auto const& c : v1)
        std::cout << c << ' ';
}
