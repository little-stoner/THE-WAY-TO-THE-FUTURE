//
// Created by viber on 2023/10/7.
//

#include <iostream>

int main() {


    string s1 = "a string", *p = &s1;
    auton = s1.size();// run the size member of the string s1
    n = (*p).size(); // run size on the object to which p points
    n = p->size(); // equivalent to (*p).size()

    return 0;
}

