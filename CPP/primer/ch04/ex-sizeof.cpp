//
// Created by viber on 2023/10/7.
//

#include <iostream>




int main() {

    // sizeof (type)
    // sizeof expr

    Sales_data data, *p;

    sizeof(Sales_data); // size required to hold an object of type Sales_data
    sizeof data;// size of data’s type,i.e.,sizeof(Sales_data)
    sizeof p; // size of a pointer
    sizeof *p; // size of the type to which p points, i.e., sizeof(Sales_data)
    sizeof data.revenue;// size of the type of Sales_data’s revenue member
    sizeof Sales_data::revenue; // alternative way to get the size of revenue

    // sizeof(ia)/sizeof(*ia) returns the number of elements in ia
    int ia[2];
    constexpr size_t sz = sizeof(ia)/sizeof(*ia);
    int arr2[sz]; // ok sizeof returns a constant expression § 2.4.4 (p. 65)



    return 0;
}