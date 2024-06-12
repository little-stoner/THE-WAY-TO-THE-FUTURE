//
// Created by viber on 2023/10/12.
//

#include <iostream>
#include <string>
#include <vector>
#include <sstream>

//morgan 2015552368 8625550123
//drew 9735550130
//lee 6095550132 2015550175 8005550000

// members are public by default
struct PersonInfo {
    std::string name;
    std::vector <std::string> phones;
};

bool valid(const std::string &s)
{
    // we'll see how to validate phone numbers
    // in chapter 17, for now just return true
    return true;
}

std::string format(const std::string &s) { return s; }


std::ostream& process(std::ostream &os, std::vector<PersonInfo> people) {
    for (const auto &entry : people) {
        std::ostringstream formatted, badNums;
        for (const auto &nums : entry.phones) {
            if (!valid(nums)) {
                badNums << " " << nums; // string in badNums
            } else {
                // ‘‘writes’’to formatted’s string
                formatted << " " << format(nums);
            }
        }
        if (badNums.str().empty())
            os << entry.name << " "
               << formatted.str() << std::endl;
        else
            std::cerr << "input error: " << entry.name
                      << " invalid number(s) " << badNums.str() << std::endl;
    }
}

int main() {
    std::string line, word;
    std::vector<PersonInfo> people;

    while (getline(std::cin, line)) {
        PersonInfo info;
        std::istringstream record(line);
        record >> info.name;
        while (record >> word)
            info.phones.push_back(word);
        people.push_back(info);
    }


    return 0;
}

