//
// Created by viber on 2022/4/18.
//

#include <iostream>
#include <cassert>
#include <cstdint>
#include <limits>

constexpr std::int64_t powint_safe(std::int64_t base, int exp) {
    assert(exp >= 0 && "powint_safe: exp parameter has negative value");
    if (base == 0)
        return (exp == 0) ? 1 : 0;
    std::int64_t result{1};
    //
    bool negativeResult{false};
    if (base < 0) {
        base = -base;
        negativeResult = (exp & 1);
    }
    while (exp > 0) {
        if (exp & 1) {
            if (result > std::numeric_limits<std::int64_t>::max() / base) {
                std::cerr << "powint_safe(): result overflowed\n";
                return std::numeric_limits<std::int64_t>::max();
            }
            result *= base;
        }
        exp /= 2;
        if (exp <= 0) {
            break;
        }
        if (base > std::numeric_limits<std::int64_t>::max() / base) {
            std::cerr << "powint_safe(): result overflowed\n";
            return std::numeric_limits<std::int64_t>::max();
        }
        base *= base;
    }
    if (negativeResult) {
        return -result;
    }
    return result;
}

int main() {

    return 0;
}