#include <stdio.h>

int main(int argc, char** argv){
    int a[4] = {0, 1, 2, 3};

    for (int i; i < 4; i++){
        printf("%d is where %d is stored in memory\n",&a[i], a[i]);
    }

    return 0;
}
