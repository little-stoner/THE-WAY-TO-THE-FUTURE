//
// Created by viber on 2023/1/19.
//

#include <stdio.h>
#include <stdlib.h>

int getline0(char *line, int lim);
void copy(char *to, char *from);

int main() {
    int len = 5;
    int max = 0;
    char *line = malloc(sizeof(char) * len);
    while ((len = getline0(line, len)) > 0) {
        if (len > max) {
            max = len;
        }
    }

    for (int i = 0; i <= max; ++i) {
        printf("%c", line[i]);
    }
    printf("\n");

    free(line);
    return 0;
}

int getline0(char *line, int len) {
    int c, i;
    for (i = 0; (c = getchar()) != EOF && c != '\n'; ++i) {
        if (i == (len - 1)) {
            char *na = malloc(sizeof(char) * len * 2);
            copy(na, line);
            line = realloc(line, sizeof(char) * len * 2);
            copy(line, na);
            free(na);
        }
        line[i] = c;
    }
    if (c == '\n') {
        line[i] = c;
        i++;
        line[i] = '\0';
    }
    return i;
}

void copy(char *to, char *from) {
    int i = 0;
    while ((to[i] = from[i]) != '\0') i++;
}
