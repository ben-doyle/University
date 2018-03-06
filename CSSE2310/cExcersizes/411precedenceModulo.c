#include <stdio.h>

int main(int argc, char** argv){
printf("%d %d %d\n", (5+2*72%7), ((5+2*72)%7),
            (5+2*(72%7))); //Continues from prv line;
    if ((5+2*72%7) == ((5+2*72)%7)){
            printf("+ is evaluated first\n");
    } else if ((5+2*72%7)==(5+2*(72%7))){
        printf("Modulo is evaluated first\n");
    } else {
        printf("Somthing has gone horribly wrong\n");
    }
    return 0;
}
