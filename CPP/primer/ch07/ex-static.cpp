//
// Created by viber on 2023/10/12.
//

#include <iostream>

class Account {
public:
    void calculate() { amount += amount * interestRate; }

    static double rate() { return interestRate; }

    static void rate(double);

private:
    std::string owner;
    double amount;
    static double interestRate;

    static double initRate();
};

void Account::rate(double newRate) {
    interestRate = newRate;
}
double Account::interestRate = initRate();

int main() {


    return 0;
}