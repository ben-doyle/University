#include <stdio.h>

int main(int argc, char** argv){
    printf("%d %d %d\n", (2+3*7), ((2+3)*7),
            (2+(3*7))); //Continues from prv line;
    if ((2+3*7) == ((2+3)*7)){
            printf("+ is evaluated first\n");
    } else if ((2+3*7)==(2+(3*7))){
        printf("* is evaluated first\n");
    } else {
        printf("Somthing has gone horribly wrong\n");
    }
    return 0;
}
