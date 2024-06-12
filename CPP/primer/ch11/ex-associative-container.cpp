//
// Created by viber on 2023/10/13.
//

#include <iostream>
#include <map>
#include <set>

int main() {

    // count the number of times each word occurs in the input
    map <string, size_t> word_count;// empty map from string to size_t
    string word;
    while (cin >> word)
        ++word_count[word]; // fetch and increment the counter for word
    for (const auto &w : word_count) // for each element in the map
        // print the results
        cout << w.first << " occurs " << w.second
             << ((w.second > 1) ? " times" : " time") << endl;

    // list initialization
    set <string> exclude = {"the", "but", "and", "or", "an", "a",
                            "The", "But", "And", "Or", "An", "A"};
    // three elements; authors maps last name to first
    map <string, string> authors = {{"Joyce",   "James"},
                                    {"Austen",  "Jane"},
                                    {"Dickens", "Charles"}};

    // define a vector with 20 elements, holding two copies of each number from 0 to 9
    vector<int> ivec;
    for (vector<int>::size_type i = 0; i != 10; ++i) {
        ivec.push_back(i);
        ivec.push_back(i); // duplicate copies of each number
    }
    // iset holds unique elements from ivec; miset holds all 20 elements
    set<int> iset(ivec.cbegin(), ivec.cend());
    multiset<int> miset(ivec.cbegin(), ivec.cend());
    cout << ivec.size() << endl;// prints 20
    cout << iset.size() << endl;// prints 10
    cout << miset.size() << endl;// prints 20



    return 0;
}

