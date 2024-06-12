
//
// Created by viber on 2023/11/1.
//

#include <iostream>

struct Employee {
    int id{};
    int age{};
    double wage{};
};

void printEmployee(const Employee& employee) {
    std::cout << "ID: " << employee.id << '\n';
    std::cout << "Age: " << employee.age << '\n';
    std::cout << "Wage: " << employee.wage << '\n';
}
void printEmployeeP(const Employee* employee) {
    // (*employee).id => employee->id
    std::cout << "ID: " << employee->id << '\n';
    std::cout << "Age: " << employee->age << '\n';
    std::cout << "Wage: " << employee->wage << '\n';
}

int main() {
    Employee joe {14, 32, 12.12};
    Employee frank { 15, 28, 18.12};
    printEmployee(joe);
    std::cout << '\n';
    printEmployee(frank);
    printEmployeeP(&frank);
    return 0;
}