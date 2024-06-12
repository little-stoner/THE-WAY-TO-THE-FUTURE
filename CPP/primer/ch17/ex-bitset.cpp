//
// Created by viber on 2023/10/19.
//

#include <iostream>

int main() {
    bitset<32> bitvec(1U);
    // bitvec1 is smaller than the initializer; high-order bits from the initializer are discarded
    bitset<13> bitvec1(0xbeef); // bits are 1111011101111
    // bitvec2 is larger than the initializer; high-order bits in bitvec2 are set to zero
    bitset<20> bitvec2(0xbeef); // bits are 00001011111011101111
    // on machines with 64-bit long long 0ULL is 64bits of 0,so ~0ULL is 64 ones
    bitset<128> bitvec3(~0ULL); // bits 0 . . . 63 are one; 63 . . . 127 are zero
    //
    bitset<32> bitvec4("1100");// bits2and3are1,all others are 0
    //
    string str("1111111000000011001101");
    bitset<32> bitvec5(str, 5, 4);// four bits starting at str[5],1100
    bitset<32> bitvec6(str, str.size() - 4); // use last four characters

    //
    bitset<32> bitvec(1U); // 32 bits; low-order bit is 1, remaining bits are 0
    bool is_set = bitvec.any(); // true, one bit is set
    bool is_not_set = bitvec.none(); // false, one bit is set
    bool all_set = bitvec.all(); // false, only one bit is set size_t
    onBits = bitvec.count(); // returns 1
    size_tsz = bitvec.size(); // returns32
    bitvec.flip(); // reverses the value of all the bits in bitvec
    bitvec.reset();  // sets all the bits to 0
    bitvec.set(); // sets all the bits to 1

    //
    bitvec.flip(0); // reverses the value of the first bit
    bitvec.set(bitvec.size() - 1); // turns on the last bit
    bitvec.set(0, 0); // turns off the first bit
    bitvec.reset(i); // turns off the ith bit
    bitvec.test(0); // returns false because the first bit is off

    bitvec[0] = 0; // turn off the bit at position 0

    bitvec[31] = bitvec[0]; // set the last bit to the same value as the first bit
    bitvec[0].flip(); // flip the value of the bit at position 0
    ~bitvec[0]; // equivalent operation; flips the bit at position 0
    boolb = bitvec[0]; //convert the value of bit vec[0] to bool

    return 0;
}

