#include <iostream>

using namespace std;

class A {
public:
    A() { cout << "A's constructor called" << endl; }
};

class B {
public:
    B() { cout << "B's constructor called" << endl; }
};

class C : public B, public A {
public:
    C() { cout << "C's constructor called" << endl; }
};


class Person {
public:
    Person(int x) { cout << "Person::Person(int) called" << endl; }

    Person() { cout << "Person::Person() called" << endl; }
};

class Faculty : public Person {
public:
    Faculty(int x) : Person(x) {
        cout << "Faculty::Faculty(int) called" << endl;
    }
};

class Faculty0 : virtual public Person {
public:
    Faculty0(int x) : Person(x) {
        cout << "Faculty::Faculty(int ) called" << endl;
    }
};

class Student : public Person {
    // data members of Student
public:
    Student(int x) : Person(x) {
        cout << "Student::Student(int ) called" << endl;
    }
};

class Student0 : virtual public Person {
public:
    Student0(int x) : Person(x) {
        cout << "Student::Student(int ) called" << endl;
    }
};

class TA : public Faculty, public Student {
public:
    TA(int x) : Student(x), Faculty(x) {
        cout << "TA::TA(int ) called" << endl;
    }
};

class TA0 : public Faculty0, public Student0 {
public:
    TA0(int x) : Student0(x), Faculty0(x) {
        cout << "TA::TA(int ) called" << endl;
    }
};

int main() {
    TA ta1(30);
    cout << " ===================== " << endl;
    TA0 ta0(30);
}
