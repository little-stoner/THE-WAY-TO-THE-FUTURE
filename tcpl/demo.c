#include <stdio.h>
#include <ucontext.h>
#include <unistd.h>
#include <stdlib.h>

int main() {

    ucontext_t ctx = { 0 };

    getcontext(&ctx);

    puts("Hello world");
    sleep(1);

    setcontext(&ctx);

    return EXIT_SUCCESS;
    
}
