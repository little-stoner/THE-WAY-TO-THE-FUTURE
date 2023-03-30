//
// Created by viber on 2023/1/4.
//

#include <stdio.h>

int main() {

    FILE *fp;

    fp = fopen("./1-4.c", "r");

    int c = getc(fp);
    while (c != EOF) {
        c = getc(fp);
        printf(">> %d\t", c);
    }

}



