#include <stdio.h>
#include <stdlib.h>

int mystrlen(const char* str1);
char* stringadd(const char* s1, const char* s2);

int main(int argc, char** argv) {
    printf("%s\n", stringadd("hello", "Goodbye"));
    return 0;
}

int mystrlen(const char* str1){
    int count = 0;
    char char1 = str1[count];
    while (char1) {
        //printf("%d is the counter\n", count);
        count++;
        char1 = str1[count];
    }
    return count;
}

char* stringadd(const char* s1, const char* s2){
    int s1size = mystrlen(s1);
    int s2size = mystrlen(s2);
    char* result = malloc(sizeof(char) * (s1size + s2size + 1));
    for (int i = 0; i < s1size; ++i)
    {
        result[i] = s1[i];
    }
    for (int i = 0; i < s2size; ++i)
    {
        result[s1size + i] = s2[i];
    }
    return result;
}
