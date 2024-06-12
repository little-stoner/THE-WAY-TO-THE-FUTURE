//
// Created by viber on 2023/10/7.
//

#include <iostream>
#include <vector>

int main() {

    int i = 0, j = 0;
    const int ci = i;

    int k = 0;
    std::cout << " k: " << k << std::endl;
    k = 3.1419265358;
    std::cout << " k: " << k << std::endl;

    // right associate
    int ival, jval;
    ival = jval = 0; // ok: each assigned 0

    int iival, *ppval; // ival is an int; pval is a pointer to int
    iival = ppval = 0; // error: cannot assign the value of a pointer to an int
    std::string s1, s2;
    s1=s2="OK"; // stringliteral"OK"convertedtostring

    //
    k = {3.14}; // error: narrowing conversion
    std::vector<int> vi; // initially empty
    vi = {0,1,2,3,4,5,6,7,8,9}; // vi now has ten elements, values 0 through 9
    //
    auto pbeg = vi.begin();
    // print elements up to the first negative value while (pbeg != v.end() && *beg >= 0)
    std::cout << *pbeg++ << std::endl; // print the current value and advance pbeg

    return 0;
}

