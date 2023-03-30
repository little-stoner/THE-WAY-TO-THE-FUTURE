//
// Created by viber on 2023/1/26.
//

#include <stdio.h>

#define IN 1
#define OUT 0
#define MAXLINE 1000

int getline0(char s[], int lim);
void copy(char to[], char from[]);


int main() {
    int len;
    int max;
    char line[MAXLINE];
    char longest[MAXLINE];

    max = 0;
    while ((len = getline0(line, MAXLINE)) > 0) {
        if (len > 0 && len > max) {
            max = len;
            copy(longest, line);
        }
    }
    if (max > 0) {
        printf("%s", longest);
    }

    return 0;
}

int getline0(char s[], int lim) {
    int c, i, state, pos;
    for (i = 0; i < lim - 1 && (c = getchar()) != EOF && c != '\n'; i++) {
        if (c != '\t' && c != ' ') {
            state = OUT;
            pos = i;
        } else {
            state = IN;
        }
        s[i] = c;
    }
    if (c == '\n') {
        s[i] = c;
        i++;
    }
    s[i] = '\0';
    if (state == IN) {
        i = pos;
    }
    return i;
}

void copy(char to[], char from[]) {
    int i = 0;
    while ((to[i] = from[i]) != '\0') i++;
}