//
// Created by viber on 2023/9/27.
//

#include <string>
#include <iostream>

class Quote {
public:
    Quote() = default;

    Quote(const std::string &book, double sales_price)
            : bookNo(book), price(sales_price) {}

    std::string isbn() const { return bookNo; }

    virtual double net_price(std::size_t n) const {
        return n * price;
    }

    virtual ~Quote() = default;

private:
    std::string bookNo;
protected:
    double price = 0.0;
};

class Bulk_quote : public Quote {
public:
    Bulk_quote() = default;

    Bulk_quote(const std::string &book, double price, std::size_t qty, double disc)
            : Quote(book, price), min_qty(qty), discount(disc) {};

    double net_price(std::size_t n) const override {
        if (n >= min_qty) {
            return n * (1 - discount) * price;
        }
        return n * price;
    }

private:
    std::size_t min_qty = 0;
    double discount = 0.0;
};

double print_total(std::ostream &os, const Quote &item, size_t n) {
    double ret = item.net_price(n);
    os << "ISBN: " << item.isbn()
       << " # sold: " << n << " total due: " << ret << std::endl;
    return ret;
}

int main() {
    Quote q = Quote("aaa", 1.0);
    Bulk_quote b = Bulk_quote("bbb", 2.0, 2, 0.1);
    print_total(std::cout, q, 2);
    print_total(std::cout, b, 2);
    return 0;
}