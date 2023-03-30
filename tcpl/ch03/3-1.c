//
// Created by viber on 2023/1/28.
//
#include <stdio.h>

int binsearch(int x, int v[], int n);

int main() {
    int v[] = { 1, 2, 3, 4, 5, 6, 7 };
    printf(">>> %d\n", binsearch(3, v, 7));
    return 0;
}

int binsearch(int x, int v[], int n) {
    int low, high, mid;
    low = 0;
    high = n - 1;
    while (low <= high) {
        mid = (low + high) / 2;
        if (x < v[mid]) {
            high = mid - 1;
        }
        else if (x > v[mid]) {
            low = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}

int binsearch0(int x, int v[], int n) {
    int low, high, mid;
    low = 0;
    high = n - 1;
    mid = (low + high) / 2;
    while (x != v[mid]) {
        if (x < v[mid]) {
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
        mid = (low + high) / 2;
    }
    if (x == v[mid]) return mid;
    return -1;
}