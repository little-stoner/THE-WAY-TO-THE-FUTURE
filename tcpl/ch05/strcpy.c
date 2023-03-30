//
// Created by viber on 2023/2/11.
//

void strcopy(char *s, char *t) {
    int i;
    i = 0;
    while ((s[i] = t[i]) != '\0')
        i++;
}

void strcopy0(char *s, char *t) {
    while ((*s = *t) != '\0') {
        s++;
        t++;
    }
    //
    while ((*s++ == *t++) != '\0')
        ;
}
