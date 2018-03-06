#include <stdio.h>

void swap3(int* a, int* b, int* c){
    int temp1;

    printf("a=%d b=%d c=%d\n", *a, *b, *c);
    temp1 = *a;
    *a = *b;
    *b = *c;
    *c = temp1;

    //printf("a=%d b=%d c=%d\n", *a, *b, *c);
}

int main(int argc, char** argv){
    int a = 0;
    int b = 1;
    int c = 2;
    swap3(&a, &b, &c);
    printf("a=%d b=%d c=%d\n", a, b, c);
    return 0;
}
