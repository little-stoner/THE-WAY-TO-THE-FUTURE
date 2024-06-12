//
// Created by viber on 2023/10/1.
//
#include <iostream>
#include "Sales_item.h"

int main() {

     Sales_item current;
    if (std::cin >> current) {
        Sales_item next;
        int cnt = 0;
        while (std::cin >> next) {
            if (current.isbn() == next.isbn()) {
                ++cnt;
            } else {
                std::cout << current.isbn() << " occurs "
                          << cnt << " times " << std::endl;
                current = next;
                cnt = 1;
            }
        }
        std::cout << current.isbn() << " occurs "
                  << cnt << " times " << std::endl;
    }
    return 0;
}

