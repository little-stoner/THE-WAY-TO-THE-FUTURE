//
// Created by viber on 2023/1/19.
//

#include <stdio.h>

void reverse(char s[]);
void copy(char to[], char from[]);

int main() {
    char s[] = { 'a', 'b', 'c', 'd', 'e', 'f', '\0' };
    printf(" >> s before: %s\n", s);
    reverse(s);
    printf(" >> s after: %s\n", s);
}

void reverse(char s[]) {
    int len = 0;
    while (s[len] != '\0') len++;
    char ns[len];
    copy(ns, s);
    for (int i = 0, temp = --len; i < temp; ++i, --len) {
        s[i] = ns[len];
    }

}

void copy(char to[], char from[]) {
    int i;
    i = 0;
    while ((to[i] = from[i]) != '\0') i++;
}

