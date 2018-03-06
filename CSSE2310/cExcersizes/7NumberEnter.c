#include <stdio.h>

int main(int argc, char** argv)
{
    int number;
    do {
        printf("Enter a number: ");
        scanf("%d", &number);
        printf("Number was %d\n", number);
    } while (number != 0);
    return 0;
}
