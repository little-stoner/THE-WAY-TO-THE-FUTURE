//
// Created by viber on 2023/10/11.
//

#include <iostream>
#include <string>
#include <vector>

class Screen {

    friend class Window_mgr;

public:
    typedef std::string::size_type pos;

    Screen() = default;

    Screen(pos ht, pos wd, char c) : height(ht), width(wd), contents(ht * wd, c) {}

    char get() const {
        return contents[cursor];
    }


    inline char get(pos ht, pos wd) const;

    Screen &move(pos r, pos c);

    void some_member() const;

    Screen &set(char);

    Screen &set(pos, pos, char);

    // display overloaded on whether the object is const or not
    Screen &display(std::ostream &os) {
        do_display(os);
        return *this;
    }
    const Screen &display(std::ostream &os) const {
        do_display(os);
        return *this;
    }


private:
    pos cursor = 0;
    pos height = 0, width = 0;
    std::string contents;
    mutable size_t access_ctr; // may change even in a const object

    void do_display(std::ostream &os) const { os << contents; }
};

inline Screen &Screen::move(pos r, pos c) {
    pos row = r * width;
    cursor = row + c;
    return *this;
}

char Screen::get(pos r, pos c) const // declared as inline in the class
{
    pos row = r * width; // compute row location
    return contents[row + c]; // return character at the given column
}

void Screen::some_member() const {
    ++access_ctr; // keep a count of the calls to any member function
    // whatever other work this member needs to do
}

inline Screen &Screen::set(char c) {
    contents[cursor] = c; // set the new value at the current cursor location
    return *this; // return this object as an lvalue
}

inline Screen &Screen::set(pos r, pos col, char ch) {
    contents[r * width + col] = ch; // set specified location to given value
    return *this; // return this object as an lvalue
}


class Window_mgr {
public:
    // location ID for each screen on the window
    using ScreenIndex = std::vector<Screen>::size_type;
    // reset the Screen at the given position to all blanks
    void clear(ScreenIndex);
private:
    // Screens this Window_mgr is tracking
    // by default, a Window_mgr has one standard sized blank Screen
    std::vector<Screen> screens{Screen(24, 80, ' ')};
};

void Window_mgr::clear(ScreenIndex i) {
    // s is a reference to the Screen we want to clear
    Screen &s = screens[i];
    // reset the contents of that Screen to all blanks
    s.contents = std::string(s.height * s.width, ' ');
}

int main() {


    return 0;
}

