//
// Created by viber on 2023/1/28.
//

//
int bitcount(unsigned int x) {
    int n = 0;
    while (x != 0) {
        x &= (x - 1);
        n++;
    }
    return n;
}