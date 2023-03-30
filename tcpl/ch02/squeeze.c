//
// Created by viber on 2023/1/28.
//

void squeeze(int s[], int c) {
    int i, j;
    for (i = 0, j = 0; s[i] != '\0'; ++i) {
        if (s[i] != c) {
            s[j++] = s[i];
        }
    }
    s[j] = '\0';
}
