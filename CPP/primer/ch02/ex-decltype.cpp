//
// Created by viber on 2023/10/3.
//

#include <iostream>

int main() {

    int i = 42, *p = &i, &r = i;
    decltype(r + 0) b;
    decltype(*p) c = i;

    return 0;
}

