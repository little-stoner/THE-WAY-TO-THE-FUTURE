//
// Created by viber on 2023/10/4.
//

#include <string>

using std::string;
using std::cout;
using std::cin;
using std::endl;

int main() {
    string line;
    while (getline(cin, line)) {
        if (!line.empty()) {
            cout << line << endl;
        }
        if (line.size() > 80) {
            cout << line << endl;
        }
    }
    return 0;
}

