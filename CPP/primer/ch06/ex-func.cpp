//
// Created by viber on 2023/10/9.
//

#include <iostream>

// factorial of val is val*(val-1)* (val-2). . .*((val- (val-1))*1)
int fact(int val) {
    int ret = 1; // local variable to hold the result as we calculate it
    while (val > 1)
        ret *= val--; // assign ret*val to ret and decrement val
    return ret; // return the result
}

// local static object
size_t count_calls()
{
    static size_t ctr = 0; // value will persist across calls
    return ++ctr;
}


int main() {

    int j = fact(5); // j equals 120, i.e., the result of fact(5)
    std::cout << "5! is " << j << std::endl;




    return 0;
}