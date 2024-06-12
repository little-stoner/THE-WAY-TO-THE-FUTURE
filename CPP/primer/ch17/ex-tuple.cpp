//
// Created by viber on 2023/10/19.
//


#include <iostream>
#include <tuple>
#include <string>
#include <vector>
#include <list>

using namespace std;

int main() {

    std::tuple<size_t, size_t, size_t> threeD; // all three members set to 0
    tuple<string, vector<double>, int, list<int>>
            someVal("constants", {3.14, 2.718}, 42, {0,1,2,3,4,5});
    //
    // tuple<size_t, size_t, size_t> threeD = {1,2,3}; // error
    tuple<size_t, size_t, size_t> threeDD{1,2,3}; // ok

    //

    // tuple that represents a bookstore transaction: ISBN, count, price per book
    auto item = make_tuple("0-999-78345-X", 3, 20.00);
    auto book = get<0>(item); // returns the first member of item
    auto cnt = get<1>(item); // returns the second member of item
    auto price = get<2>(item)/cnt; // returns the last member of item
    get<2>(item) *= 0.8; // apply 20% discount


    return 0;
}
