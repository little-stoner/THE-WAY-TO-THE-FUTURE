//
// Created by viber on 2023/10/4.
//

#include <iostream>

using std::cin;

using std::cout; using std::endl;

void read_number() {
    cout << "Enter two numbers: " << endl;
    int v1, v2;
    cin >> v1 >> v2;
    cout << "The sum of " << v1 << " and " << v2
         << " is " << v1 + v2 << endl;
}

int main() {
    int i;
    cin >> i;
    cout << i;
    std::cout << i;
    return 0;
}
