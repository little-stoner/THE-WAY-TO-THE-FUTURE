//
// Created by viber on 2023/10/7.
//

#include <iostream>

int main() {

    unsigned char bits = 0233; // 10011011

    bits << 8;                 // 00000000 00000000 10011011 00000000

    bits << 31;                // 10000000 00000000 00000000 00000000

    bits >> 3;                 // 00000000 00000000 00000000 00010011

    ~bits;                     // 11111111 11111111 11111111 01101000

    unsigned char b1 = 0145;   // 01100101
    unsigned char b2 = 0257;   // 10101111
    b1 & b2;                   // 24 high-order bits all 0 00100101
    b1 | b2;                   // 24 high-order bits all 0 11101111
    b1 ^ b2;                   // 24 high-order bits all 0 11001010

    unsigned long quiz1 = 0;
    quiz1 |= 1UL << 27; // indicate student number 27 passed
    quiz1 = quiz1 | 1UL << 27; // equivalent to quiz1 |= 1UL << 27
    quiz1 &= ~(1UL << 27); // student number 27 failed
    bool status = quiz1 & (1UL << 27);


    return 0;
}
