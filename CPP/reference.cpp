#include <stdio.h>
#include <iostream>

int main() {
    // int x = 5;
    // int y = 6;
    // int *p;
    // std::cout << "============" << "\n";
    // p = &x;
    // std::cout << " p: " << p << "\n";
    // p = &y;
    // std::cout << " p: " << p << "\n";
    // *p = 10;
    // std::cout << " x: " << x << "\n";
    // std::cout << " y: " << y << "\n";

    // int &r = x;
    // std::cout << " r: " << r << "\n";
    // std::cout << " &r: " << &r << "\n";
    // r = 1;
    // std::cout << " x: " << x << "\n";
    // std::cout << " r: " << r << "\n";

    std::cout << " ================================ " <<  "\n";

    int x = 0;
    int &r = x;
    std::cout << " ================================ " <<  "\n";
    std::cout << " r: " << r << "\n";
    std::cout << " &r: " << &r << "\n";
    std::cout << " x: " << x << "\n";
    std::cout << " &x: " << &x << " \n";
    
    int *p = &x;
    int *p2 = &r;
    
    std::cout << " p: " << p << "\n";
    std::cout << " p2: " << p2 << "\n";    
    
    assert(p == p2);
    
    std::cout << " ================================ " <<  "\n";
    int a = 0;
    int b = 0;
    int *m = &a;
    int *n = &b;
    int **mm = &m;
    mm = &n; // *mm = n;
    **mm = 4;

    std::cout << " a: " << a <<  "\n";
    std::cout << " b: " << b <<  "\n";
    
    
    
    
}
