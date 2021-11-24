#include <stdio.h>

#define IN 1
#define OUT 0
#define MAXLINE 1000

int getline0(char s[], int lim);
void copy(char to[], char from[], int span);
void reset(char dest[]);
void reverse(char s[]);

int main() {

    int len = 0;
    char line[MAXLINE] = {0};
    int c, i;
    char result[MAXLINE] = {0};

    for (i = 0; i < MAXLINE - 1 && (c = getchar()) != EOF; i++) {
        line[i] = c;
        len++;
        if (c == '\n') {
            // line[i] = c;
            int start = (i + 1 - len);
            int p = 0;
            for (int m = i; m > start; m--) {
                if (line[m] == ' ' || line[m] == '\t' || line[m] == '\n') {
                    p = m;
                } else {
                    break;
                }
            }

            if (p == 0 || (p == start + 1 && line[start] == ' ')) {
                
            } else {
                for (int j = start; j < p; j++) {
                    //printf("%c", line[j]);
                    result[j - start] = line[j];
                }
                printf("%s", result);
                printf("$\n");
                reverse(result);
                printf("\n");
                // printf("start: %d, p: %d\n", start, p);                
            }

            len = 0;
            reset(result);
        }
    }
    
}
void reverse0(char s[]) {
    for (int i=MAXLINE; i > 0; i--) {
        char v = s[i];
        if (v == ' ' || v == '\t') {
            
        } else {
            putchar(s[i]);
        }
    }
}
void reverse(char s[]) {
    int a = 0;
    char result[MAXLINE] = {0};
    for (int i=MAXLINE; i > 0; i--) {
        char v = s[i];
        if (a == 1) {
            printf("%c", v);
        }
        else {            
            if (v == ' ' || v == '\t') {
                a = 0;
            } else {
                a = 1;
            }
        }
    }
    printf("%s", result);
}

int main0() {

    int len;
    char line[MAXLINE] = {0};
    int c, i;
    int state = OUT;
    char result[MAXLINE] = {0};

    int p = 0, j = 0;
    for (i = 0; i < MAXLINE - 1 && (c = getchar()) != EOF; i++) {
        if (c == ' ' || c == '\t' || c == '\n') {
            if (state == IN) {
                
            } else {
                line[j++] = c;
            }
            state = OUT;
        } else {
            state = IN;
            p = i;
            line[j++] = c;
        }

        if (c == '\n') {
            copy(result, line, p + 1);                
            printf("%s", result);
            printf("$\n");
            reset(line);
            reset(result);
            j = 0;
            p = 0;            
        } else {
        }
        state = OUT;
    }

    printf("\n");
    printf("--- end of story ---\n");
    
    return 0;
    
}

void reset(char dest[]) {
    for (int i = 0; i < MAXLINE; i++) {
        dest[i] = '\0';
    }
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
    s[i] = '\0'; // this remove '\0'
    return i;
}

int getline00(char s[], int lim) {
    int c, i;
    int p = 0, state = OUT;
    for (i = 0; i < lim - 1 && (c = getchar()) != EOF && c != '\n'; i++) {
        if (c == ' ' || c == '\t') {
            state = OUT;
        } else {
            state = IN;
            p = i;
            // putchar(c);
        }
        s[i] = c;        
    }
    
    if (p > 0 && state == OUT && c == '\n') {
        s[i] = c;        
        return p + 1;
    }
    
    if (p == 0 && state == OUT && c == '\n') {
        return -1;
    }
    return p + 1;
    
    //if (c == '\n') {
    //s[i] = c;
    //}
    // s[i] = '\0'; // this remove '\0'
}

void copy(char to[], char from[], int span) {
    int i = 0;
    while(i < span) {
        to[i] = from[i];
        i++;
    }    
}
