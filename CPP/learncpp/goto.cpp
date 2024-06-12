//
// Created by viber on 2023/10/24.
//

#include <iostream>

void tryAgain() {
    int x{0};
    tryAgain:
    if (x < 3) {
        ++x;
        std::cout << " goto tryAgain " << std::endl;
        goto tryAgain;
    }
    std::cout << " finish " << std::endl;
}

void fnScope(bool skip) {
    if (skip) {
        goto end;
    }
    std::cout << "cast\n";
    end:
    ;
}

int main() {

    tryAgain();
    //
    fnScope(true);
    fnScope(false);

    return 0;
}

