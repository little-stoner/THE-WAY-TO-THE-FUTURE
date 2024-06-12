//
// Created by viber on 2023/10/6.
//

#include <iostream>

int main() {

    int ia[3][4] = {
            {0, 1, 2,  3},
            {4, 5, 6,  7},
            {8, 9, 10, 11}
    };

    std::cout << " ia: " << ia << std::endl;

    constexpr size_t rowCnt = 3, colCnt = 4;
    int iaa[rowCnt][colCnt];
    for (size_t i = 0; i != rowCnt; ++i) {
        for (size_t j = 0; j != colCnt; ++j) {
            iaa[i][j] = i * colCnt + j;
        }
    }


    return 0;
}
