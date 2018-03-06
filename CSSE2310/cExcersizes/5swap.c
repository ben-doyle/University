#include <stdio.h>

void swap(int* p, int* q){
    int temp;
    printf("p=%d q=%d\n", *p, *q);
    temp = *p;
    *p = *q;
    *q = temp;
    printf("p=%d q=%d\n", *p, *q);
}

int main(int argc, char** argv){
    int a = 3, b = 4;
    swap(&a, &b);
    printf("a=%d, b=%d\n", a, b);
    return 0;
}
