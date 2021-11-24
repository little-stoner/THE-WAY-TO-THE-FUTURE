#include <stdio.h>

float f2c(float fahr);

int main() {
    for (float fahr = 300; fahr >= 0; fahr = fahr - 20) {
        printf("%3.0f %6.1f\n", fahr, f2c(fahr));
    }
    return 0;
}

float f2c(float fahr) {
    int celsius = (fahr - 32.0) * 5.0 / 9.0;
    return celsius;
}
