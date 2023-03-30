//
// Created by viber on 2023/1/28.
//

void strcat0(char s[], char t[]) {
    int i, j;
    i = j = 0;
    while (s[i] != '\0') i++;
    while ((s[i++] = t[j++]) != '\0')
        ;
}
