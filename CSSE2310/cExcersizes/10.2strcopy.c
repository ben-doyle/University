#include <stdio.h>

void strcopy();

int main(int argc, char** argv) {
    strcopy();
}
void strcopy(){
    char target[20];
    char* src = "hello\n";
    int i = 0;
    for (i = 0; src[i] != '\0'; i++)
        {
            target[i] = src[i];
        }
    target[i] = '\0';
    printf("%s", target);
}
