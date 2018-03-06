#include <stdio.h>

int main(int argc, char** argv){
    short a = 1;
    short* b = &a;
    int c = 2;
    long d = 3;
    printf("%zu\n", sizeof(char));
    printf("%zu\n", sizeof(*b));
    printf("%zu\n", sizeof(c + 5));
    printf("%zu\n", sizeof(d));
    return 0;
}
