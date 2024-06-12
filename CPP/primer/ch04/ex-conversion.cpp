//
// Created by viber on 2023/10/8.
//


#include <iostream>

int main() {

    // implicit conversions
    int ival = 3.541 + 3;
    //

    bool flag;
    short sval;
    int ival;
    long lval;
    float fval;
    char cval;
    unsigned short usval;
    unsigned int uival;
    unsigned long ulval;
    double dval;

    3.14159L+'a'; // ’a’ promoted to int,then that int converted to long double
    dval + ival;  // ival converted to double
    dval + fval;  // fval converted to double
    ival = dval;  // dval converted (by truncation) to int
    flag = dval;  // if dval is 0, then flag is false, otherwise true
    cval + fval;  // cval promoted to int, then that int converted to float
    sval + cval;  // sval and cval promoted to int
    cval + lval;  // cval converted to long
    ival + ulval; // ival converted to unsigned long
    usval + ival; // promotion depends on the size of unsigned short and int
    uival + lval; // conversion depends on the size of unsigned int and long

    int ia[10]; // array of ten ints
    int* ip = ia; // convert ia to a pointer to the first element








    return 0;
}
