//
// Created by viber on 2023/10/6.
//

#include <iostream>

int main() {

    constexpr size_t sz = 5;
    int arr[sz] = {1, 2, 3, 4, 5};
    int *ip = arr;
    int *ip2 = ip + 4;

    std::cout << " ip: " << ip[0] << " ip2: " << ip2[0] << std::endl;

    return 0;
}

