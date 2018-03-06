#include <stdio.h>

int main(int argc, char** argv)
{
    int number;
    if (scanf("%d", &number) == 1 ) {
        printf("Number was %d\n", number);
    } else {
        number = 0; // Trigger the end of the loop
    }
    return 0;
}
