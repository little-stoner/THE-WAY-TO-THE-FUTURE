//
// Created by viber on 2023/10/10.
//

#include <iostream>
#include "Sales_data.h"

using namespace std;

int main() {
    Sales_data total;
    if (read(cin, total)) {
        Sales_data trans;
        while(read(cin, trans)) {
            if (total.isbn() == trans.isbn())
                total.combine(trans);
            else {
                print(cout, total) << endl;
                total = trans;
            }
        }
        print(cout, total) << endl;
    } else {
        cerr << "No data?!" << endl;
    }

    return 0;
}

