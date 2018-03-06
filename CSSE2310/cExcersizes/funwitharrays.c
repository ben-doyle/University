#include <stdio.h>

int main(int argc, char** argv)
{
    int a[4] = {0, 1, 2, 5};
    int* firstElement = &a[0];
    int* secondElement = firstElement + 1;

    printf("%d\n", secondElement);
    return 0;
}
