//
// Created by viber on 2023/10/13.
//

#include <iostream>
#include <string>
#include <memory>
#include <vector>

int main() {
    // int *pi = new int; // pi points to a dynamically allocated,
                       // unnamed, uninitialized int
    // std::string *ps = new std::string; // initialized to empty string
    // int *pi = new int; // pi points to an uninitialized int
    int *pi = new int(1024);// object to which pi points has value 1024
    // std::string *ps = new std::string(10, '9'); // *ps is "9999999999"
    // vector with ten elements with values from 0 to 9
    std::vector<int> *pv = new std::vector<int>{0,1,2,3,4,5,6,7,8,9};


    std::string *ps1 = new std::string; // default initialized to the empty string
    std::string *ps = new std::string(); // value initialized to the empty string
    int *pi1 = new int; // default initialized; *pi1 is undefined
    int *pi2 = new int(); // value initialized to 0; *pi2 is 0


    // allocate and initialize a const int
    const int *pci = new const int(1024);
    // allocate a default-initialized const empty string
    const std::string *pcs = new const std::string;


    // ifallocationfails,newreturnsanullpointer
    int *p1 = new int;// if allocation fails,new throws std::bad_alloc
    int *p2 = new (std::nothrow) int; // if allocation fails, new returns a null pointer


    std::shared_ptr<double> p11; // shared_ptr that can point at a double
    std::shared_ptr<int> p22(new int(42)); // p2 points to an int with value 42

    // std::shared_ptr<int> p1111 = new int(1024); // error: must use direct initialization
    std::shared_ptr<int> p222(new int(1024)); // ok: uses direct initialization


    return 0;
}

