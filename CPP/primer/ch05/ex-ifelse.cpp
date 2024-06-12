//
// Created by viber on 2023/10/8.
//


#include <iostream>
#include <string>

int main() {
    const vector<string> scores = {"F", "D", "C", "B", "A", "A++"};

    std::string lettergrade;
    int grade;
    if (grade < 60)
        lettergrade = scores[0];
    else
        lettergrade = scores[(grade - 50)/10];

    return 0;
}

