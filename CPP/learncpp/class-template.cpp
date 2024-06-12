//
// Created by viber on 2023/11/17.
//
#include <iostream>
#include <utility>

template <typename T, typename U>
void print(std::pair<T, U> p)
{
    std::cout << '[' << p.first << ", " << p.second << ']';
}

template <typename T>
struct Pair
{
    T first{};
    T second{};
};
int main()
{
    Pair<int> p1{ 5, 6 };        // instantiates Pair<int> and creates object p1
    std::cout << p1.first << ' ' << p1.second << '\n';

    Pair<double> p2{ 1.2, 3.4 }; // instantiates Pair<double> and creates object p2
    std::cout << p2.first << ' ' << p2.second << '\n';

    Pair<double> p3{ 7.8, 9.0 }; // creates object p3 using prior definition for Pair<double>
    std::cout << p3.first << ' ' << p3.second << '\n';

    ////////////////////////////////////////
    std::pair<int, double> p11{ 1, 2.3 }; // a pair holding an int and a double
    std::pair<double, int> p22{ 4.5, 6 }; // a pair holding a double and an int
    std::pair<int, int> p33{ 7, 8 };      // a pair holding two ints

    print(p22);

    return 0;
}