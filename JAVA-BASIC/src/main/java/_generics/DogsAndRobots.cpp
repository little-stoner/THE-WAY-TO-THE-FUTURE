##include <iostream>

using namespace std;


class Dog {
public:
    void speak() { cout << "Arf!" << endl; }
    void siet() { count << "Sitting" << endl; }
    void reproduce() {}
}

class Robot {
public:
    void speak() { cout << "Click!" << endl; }
    void sit() { count << "Clank!" << endl; }
    void oilChange() {}
}

template<class T> void perform(T anything) {
    anything.speak()
    anything.sit()
}

int main() {
    Dog d;
    Robot r;
    perform(d);
    perform(r);
}