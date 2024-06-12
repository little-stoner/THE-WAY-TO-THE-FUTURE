//
// Created by viber on 2023/10/4.
//

#ifndef ISOCPP_SALES_DATA_H
#define ISOCPP_SALES_DATA_H

#include <iostream>
#include <string>

struct Sales_data {
    std::string bookNo;
    unsigned units_sold = 0;
    double revenue = 0.0;
};

Sales_data readData() {
    Sales_data data;
    double price = 0;

    std::cin >> data.bookNo >> data.units_sold >> price;
    data.revenue = data.units_sold * price;

    return data;
}

void addData(Sales_data data1, Sales_data data2) {
    if (data1.bookNo == data2.bookNo) {
        unsigned totalCnt = data1.units_sold + data2.units_sold;
        double totalRevenue = data1.revenue + data2.revenue;
        std::cout << data1.bookNo << " " << totalCnt
                  << " " << totalRevenue << " ";
        if (totalCnt != 0) {
            std::cout << totalRevenue / totalCnt << std::endl;
        } else {
            std::cout << "(no sales)" << std::endl;
        }
    } else {
        std::cerr << " Data must refer to the same ISBN "
                  << std::endl;
    }
}

#endif //ISOCPP_SALES_DATA_H
