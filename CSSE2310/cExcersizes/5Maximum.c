#include <stdio.h>
#include <stdlib.h>

int maximum(int a, int b, int c){
    printf("a: %d, b: %d, c: %d\n", a, b , c);
    if (a > b && a > c){
        return a;
    } else if ( b > a && b > c){
        return b;
    } else {
        return c;
    }
}

int main (int argc, char** argv){
    int a = atoi(argv[1]);
    int b = atoi(argv[2]);
    int c = atoi(argv[3]);

    printf("%d is the maximum\n",
            maximum(a, b, c));
    return 0;
}
