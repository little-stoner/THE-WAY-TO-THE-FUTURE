//
// Created by viber on 2022/10/6.
//

#include <iostream>

template<typename T>
class Base {
public:
    void doSomething() {
        T& derived = static_cast<T&>(*this);
    }
};

class Derived : Base<Derived> {

};

template <typename T>
struct crtp
{
    T& underlying() { return static_cast<T&>(*this); }
    T const& underlying() const { return static_cast<T const&>(*this); }
};

template <typename T, template<typename> class crtpType>
struct crtp0
{
    T& underlying() { return static_cast<T&>(*this); }
    T const& underlying() const { return static_cast<T const&>(*this); }
private:
    crtp0(){}
    friend crtpType<T>;
};

template <typename T>
struct Scale : crtp<T>
{
    void scale(double multiplicator)
    {
        this->underlying().setValue(this->underlying().getValue() * multiplicator);
    }
};

template <typename T>
struct Square : crtp<T>
{
    void square()
    {
        this->underlying().setValue(this->underlying().getValue() * this->underlying().getValue());
    }
};

template <typename T>
struct NumericalFunctions0
{
    void scale(double multiplicator)
    {
        T& underlying = static_cast<T&>(*this);
        underlying.setValue(underlying.getValue() * multiplicator);
    }
    void square()
    {
        T& underlying = static_cast<T&>(*this);
        underlying.setValue(underlying.getValue() * underlying.getValue());
    }
    void setToOpposite()
    {
        scale(-1);
    };
};

template <typename T>
struct NumericalFunctions : public crtp<T>
{
    void scale(double multiplicator)
    {
        this->underlying.setValue(this->underlying().getValue() * multiplicator);
    }
    void square()
    {
        this->underlying.setValue(this->underlying.getValue() * this->underlying.getValue());
    }
    void setToOpposite()
    {
        scale(-1);
    };
};

class Sensitivity0 : public NumericalFunctions<Sensitivity0>
{
public:
    double getValue() const;
    void setValue(double value);
    // rest of the sensitivity's rich interface...
};

class Sensitivity : public Scale<Sensitivity>, public Square<Sensitivity>
{
public:
    double getValue() const { return value_; }
    void setValue(double value) { value_ = value; }

private:
    double value_;
};

///////////////

template <typename T>
class Amount
{
public:
    double getValue() const
    {
        return static_cast<T const&>(*this).getValue();
    }
};

class Constant42 : public Amount<Constant42>
{
public:
    double getValue() const {return 42;}
};

class Variable : public Amount<Variable>
{
public:
    explicit Variable(int value) : value_(value) {}
    double getValue() const {return value_;}
private:
    int value_;
};

template<typename T>
void print(Amount<T> const& amount)
{
    std::cout << amount.getValue() << '\n';
}

int main() {
    Constant42 c42;
    print(c42);
    Variable v(43);
    print(v);
}














