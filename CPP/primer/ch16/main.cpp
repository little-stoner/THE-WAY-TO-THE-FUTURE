//
// Created by viber on 2022/9/22.
//

#include <iostream>
#include <vector>
#include <string>

using namespace std;

template<typename T>
int compare(const T &v1, const T &v2) {
    if (v1 < v2) return -1;
    if (v2 < v1) return 1;
    return 0;
}

class Person {};

class Employee : public Person {
public:
    Employee(string fName, string lName, double sal) {

    }
    string FirstName;
    string LastName;
    double salary;
    void show() {
        std::cout << "First Name" << FirstName << " Last Name: " << LastName << " Salary: " << salary << std::endl;
    }
    void addBonus(double bonus) {
        salary += bonus;
    }
};

int main() {
    std::vector<Person> v;
    Employee employee { "A", "B", 0.2 };
    std::cout << "==========" << std::endl;
    v.push_back(employee);
    for (auto i : v) {
        // static_cast<Employee*>(&i)->show();
        ((Employee*)(&i))->show();
    }
}