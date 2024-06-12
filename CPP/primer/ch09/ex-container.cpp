//
// Created by viber on 2023/10/12.
//

#include <iostream>
#include <list>

int main() {

    list <string> a = {"Milton", "Shakespeare", "Austen"};

    auto it1 = a.begin(); // list<string>::iterator
    auto it2 = a.rbegin(); // list<string>::reverse_iterator
    auto it3 = a.cbegin(); // list<string>::const_iterator
    auto it4 = a.crbegin();// list<string>::const_reverse_iterator

    // type is explicitly specified
    list<string>::iterator it5 = a.begin();
    list<string>::const_iterator it6 = a.begin();
    // iterator or const_iterator depending on a’s type of a
    auto it7 = a.begin(); // const_iterator only if a is const
    auto it8 = a.cbegin(); // it8 is const_iterator


    // each container has three elements, initialized from the given initializers
    list<string> authors = {"Milton", "Shakespeare", "Austen"};
    vector<const char*> articles = {"a", "an", "the"};
    list<string> list2(authors); // ok: types match
    deque<string> authList(authors); // error: container types don’t match
    vector<string> words(articles); // error: element types must match
    // ok:converts const char* elements to string
    forward_list<string> words(articles.begin(), articles.end());

    // copies up to but not including the element denoted by it
    deque<string> authList(authors.begin(), it);

    vector<int>ivec(10,-1); // ten int elements, each initialized to -1
    list<string>svec(10,"hi!"); // ten strings; each elementis "hi!"
    forward_list<int> ivec(10); // ten elements, each initialized to 0
    deque<string> svec(10); // ten elements, each an empty string


    vector<int> v1 = { 1, 3, 5, 7, 9, 12 };
    vector<int> v2 = { 1, 3, 9 };
    vector<int> v3 = { 1, 3, 5, 7 };
    vector<int> v4 = { 1, 3, 5, 7, 9, 12 };
    v1 < v2 // true; v1 and v2 differ at element[2]: v1[2] is less than v2[2]
    v1 < v3 // false; all elements are equal, but v3 has fewer of them;
    v1 == v4 // true; each element is equal and v1 and v4 have the same size()
    v1 == v2 // false; v2 has fewer elements than v1

    return 0;
}

