#include <stdio.h>

int mystrlen(char* str1){
    int count = 0;
    char char1 = str1[count];
    while (char1) {
        //printf("%d is the counter\n", count);
        count++;
        char1 = str1[count];
    }
    return count;
}

int main(int argc, char** argv)
{
    if ((mystrlen("hello") == 5) && mystrlen("") == 0) {
        printf("Ok\n");
    } else {
        printf("No\n");
    }
    return 0;
}
