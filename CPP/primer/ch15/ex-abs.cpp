//
// Created by viber on 2023/10/18.
//

#include <iostream>

class Disc_quote : public Quote {
public:
    Disc_quote() = default;

    Disc_quote(const std::string &book, double price,
               std::size_t qty, double disc) : Quote(book, price), quantity(qty), discount(disc) {}

    double net_price(std::size_t) const = 0;

protected:
    std::size_t quantity = 0; // purchase size for the discount to apply
    double discount = 0.0; // fractional discount to apply
};

int main() {


    return 0;
}

