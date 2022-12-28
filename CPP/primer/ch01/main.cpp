//
// Created by viber on 2022/9/20.
//

#include <iostream>
#include "Sales_item.h"

void whilee();
void forr();
void iff();
int sameISBN() {
    Sales_item item1, item2;
    // 0-201-70353-X 4 24.99
    std::cin >> item1 >> item2;
    if (item1.isbn() == item2.isbn()) {
        std::cout << item1 + item2 << std::endl;
        return 0;
    } else {
        std::cerr << " Data must refer to same ISBN" << std::endl;
        return -1;
    }
}
void count() {
    Sales_item currVal, val;
    if (std::cin >> currVal) {
        int cnt = 1;
        while (std::cin >> val) {
            if (currVal.isbn() == val.isbn()) {
                ++cnt;
            } else {
                std::cout << currVal.isbn() << " occurs " << cnt << " times " << std::endl;
                currVal = val;
                cnt = 1;
            }
        }
        std::cout << currVal.isbn() << " occurs " << cnt << " times " << std::endl;

    }

}

void book_store() {
    Sales_item total;
    if (std::cin >> total) {
        Sales_item trans;
        while(std::cin >> trans) {
            if (total.isbn() == trans.isbn()) {
                total += trans;
            } else {
                std::cout << total << std::endl;
                total = trans;
            }
        }
        std::cout << total << std::endl;
    } else {
        std::cerr << " NO data?! " << std::endl;
    }
}

int main() {
    count();
}

void sum() {
    std::cout << "Enter two numbers:" << std::endl;
    int v1 = 0, v2 = 0;
    std::cin >> v1 >> v2;
    std::cout << "The sum of " << v1 << " and " << v2
              << " is " << v1 + v2 << std::endl;
}

void whilee() {
    int sum = 0, val = 1;
    while (val <= 10) {
        sum += val;
        ++val;
    }
    std::cout << "Sum of 1 to 10 inclusive is " << sum << std::endl;
}

void forr() {
    int sum = 0;
    for (int val = 1; val <= 10; ++val) {
        sum += val;
    }
    std::cout << "Sum of 1 to 10 inclusive is " << sum << std::endl;
}

void iff() {
    int currVal = 0, val = 0;
    if (std::cin >> currVal) {
        int cnt = 1;
        while (std::cin >> val) {
            if (val == currVal) {
                ++cnt;
            } else {
                std::cout << currVal << " occurs " << cnt << " times " << std::endl;
                currVal = val;
                cnt = 1;
            }
        }
        std::cout << currVal << " occurs " << cnt << " times " << std::endl;
    }
}