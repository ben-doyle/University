#include <stdio.h>

int main(int argc, char** argv){
    int i = 0;
    do {
        printf("%d: %s\n", i, argv[i]);
        i++;
    } while (i < argc);
    return 0;
}
