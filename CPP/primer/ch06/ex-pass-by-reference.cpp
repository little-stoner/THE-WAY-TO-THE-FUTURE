//
// Created by viber on 2023/10/10.
//

#include <iostream>

// function that takes a reference to an int and sets the given object to zero
void reset(int &i) // i is just another name for the object passed to reset
{
    i = 0; // changes the value of the object to which i refers
}

// compare the length of two strings
bool isShorter(const string &s1, const string &s2) {
    return s1.size() < s2.size();
}

// returns the index of the first occurrence of c in s
// the reference parameter occurs counts how often c occurs
string::size_type find_char(const string &s, char c,
                            string::size_type &occurs) {
    auto ret = s.size(); // position of the first occurrence, if any
    occurs = 0; // set the occurrence count parameter
    for (decltype(ret) i = 0; i != s.size(); ++i) {
        if (s[i] == c) {
            if (ret == s.size())
                ret = i; // remember the first occurrence of c
            ++occurs; // increment the occurrence count
        }
    }
    return ret; // count is returned implicitly in occurs
}

int main() {

    int n = 0, i = 42;
    int &r = n; // r is bound to n(i.e.,r is another name for n)
    r = 42; // n is now 42
    r = i; // n now has the same value as i
    i = r; // i has the same value as n


    int j = 42;
    reset(j); // j is passed by reference; the value in j is changed
    std::cout << "j=" << j << std::endl; // prints j=0



    return 0;
}

