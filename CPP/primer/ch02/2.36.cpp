//
// Created by viber on 2023/10/3.
//

#include <iostream>

int main() {
    int a = 3, b = 4;
    decltype(a) c = a;
    decltype((b)) d = a;
    ++c;
    ++d;
    return 0;
}

