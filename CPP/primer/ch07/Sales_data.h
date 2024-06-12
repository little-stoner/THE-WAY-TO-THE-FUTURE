//
// Created by viber on 2023/10/4.
//

#ifndef ISOCPP_SALES_DATA_H
#define ISOCPP_SALES_DATA_H

#include <iostream>
#include <string>

using namespace std;


struct Sales_data {

    Sales_data() = default;

    Sales_data(const std::string &s) : bookNo(s) {}

    Sales_data(const std::string &s, unsigned n, double p) : bookNo(s), units_sold(n), revenue(p * n) {}
    Sales_data(const std::string &s, unsigned n, double p, double q);

    Sales_data(std::istream &);

    std::string isbn() const { return bookNo; }

    Sales_data &combine(const Sales_data &);

    double avg_price() const;

    std::string bookNo;
    unsigned units_sold = 0;
    double revenue = 0.0;
};

// legal but sloppier way to write the Sales_data constructor: no constructor initializers
Sales_data::Sales_data(const string &s, unsigned cnt, double price, double q)
{
    bookNo = s;
    units_sold = cnt;
    revenue = cnt * price;
}


double Sales_data::avg_price() const {
    if (units_sold) {
        return revenue / units_sold;
    }
    return 0;
}

Sales_data &Sales_data::combine(const Sales_data &rhs) {
    units_sold += rhs.units_sold;
    revenue += rhs.revenue;
    return *this;
}

Sales_data add(const Sales_data &lhs, const Sales_data &rhs) {
    Sales_data sum = lhs;
    sum.combine(rhs);
    return sum;
}

std::ostream &print(std::ostream &os, const Sales_data &item) {
    os << item.isbn() << " " << item.units_sold << " "
       << item.revenue << " " << item.avg_price();
    return os;
}

std::istream &read(std::istream &is, Sales_data &item) {
    double price = 0;
    is >> item.bookNo >> item.units_sold >> price;
    item.revenue = price * item.units_sold;
    return is;
}

Sales_data::Sales_data(std::istream &is) {
    read(is, *this);
}

//int read(istream &in, Sales_data total) {
//    double t;
//    if (in >> t) {
//        total.revenue += t;
//        return 1;
//    }
//    return -1;
//}
//bool isbn(Sales_data total, Sales_data trans) {
//    if (total.bookNo == trans.bookNo) {
//        return true;
//    }
//    return false;
//}
//void combine(Sales_data total, Sales_data trans) {
//    total.revenue += trans.revenue;
//    total.units_sold += 1;
//}
//
//void print(ostream &out, Sales_data total) {
//    out << " SN: " << total.bookNo << " sold: " << total.units_sold << " revenue: " << total.revenue << endl;
//}
//
//Sales_data readData() {
//    Sales_data data;
//    double price = 0;
//
//    std::cin >> data.bookNo >> data.units_sold >> price;
//    data.revenue = data.units_sold * price;
//
//    return data;
//}
//
//void addData(Sales_data data1, Sales_data data2) {
//    if (data1.bookNo == data2.bookNo) {
//        unsigned totalCnt = data1.units_sold + data2.units_sold;
//        double totalRevenue = data1.revenue + data2.revenue;
//        std::cout << data1.bookNo << " " << totalCnt
//                  << " " << totalRevenue << " ";
//        if (totalCnt != 0) {
//            std::cout << totalRevenue / totalCnt << std::endl;
//        } else {
//            std::cout << "(no sales)" << std::endl;
//        }
//    } else {
//        std::cerr << " Data must refer to the same ISBN "
//                  << std::endl;
//    }
//}

#endif //ISOCPP_SALES_DATA_H
