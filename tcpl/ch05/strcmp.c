//
// Created by viber on 2023/2/11.
//

int strcmp(char *s, char *t) {
    int i;
    for (i = 0; s[i] == t[i]; i++) {
        if (s[i] == '\0')
            return 0;
    }
    return s[i] - s[t];
}

int strcmp0(char *s, char *t) {
    for (; *s == *t; s++, t++) {
        if (*s == '\0')
            return 0;
    }
    return *s - *t;
}
