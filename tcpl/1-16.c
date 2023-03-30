#include <stdio.h>    
#define MAXLINE 1000

// getline confilicts with <stdio.h>'s getline    
// int getline0(char *line[], int lim);
int getlinee(char s[], int lim);
void copy(char to[], char from[]);

int main() {

    int len;
    int max;
    char line[MAXLINE];
    char longest[MAXLINE];

    max = 0;
    while ((len = getlinee(line, MAXLINE)) > 0) {
        if (len > max) {
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
    int c, i;
    for (i = 0; i < lim - 1 && (c = getchar()) != EOF && c != '\n'; i++) {
        s[i] = c;
    }
    if (c == '\n') {
        s[i] = c;
        i++;
    }
    s[i] = '\0';
    return i;
}


int getlinee(char s[], int lim) {
    int c, i, j = 0;
    for (i = 0; (c = getchar()) != EOF && c != '\n'; i++) {
        if (i < lim - 1) {
            s[i] = c;
            j = i;
        }
    }
    if (c == '\n') {
        s[j]= c;
        i++;
        j++;
    }
    s[j] = '\0';
    return i;
}

void copy(char to[], char from[]) {
    int i = 0;
    while ((to[i] = from[i]) != '\0') i++;
}

