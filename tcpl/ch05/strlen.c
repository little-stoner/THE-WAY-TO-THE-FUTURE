//
// Created by viber on 2023/2/11.
//

#include <stdio.h>

#ifdef strlen
#undef strlen
#endif

int strlen(char *s) {
    int n;
    for (n = 0; *s != '\0'; s++) {
        n++;
    }
    return n;
}

int strlen0(char *s) {
    char *p = s;
    while (*p != '\0')
        p++;
    return p - s;
}
