#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char** split_line(char user_input[100]);

int main(int argc, char** argv)
{
    char user_input[100];
    printf("Input> ");
    fgets(user_input, 100, stdin);
    printf("%s\n", user_input);

    char** output = malloc(sizeof(char*) * 4);
    for (int i = 0; i < 4; i++) {
        output[i] = malloc(sizeof(char) * 24);
    }
    output = split_line(user_input);

    printf("%s\n", output[0]);
    printf("%s\n", output[1]);


    return 0;
}

char** split_line(char user_input[100]) {
    char** output = malloc(sizeof(char*) * 4);
    for (int i = 0; i < 4; i++) {
        output[i] = malloc(sizeof(char) * 24);
    }
    int count = 0;
    int j = 0;
    for (int k = 0; k < 100; ++k) {
        if (user_input[k] == '\n') {
            break;
        } if (user_input[k] == ' ') {
            count++;
            output[count][++j] == '\0';
            j = 0;
            continue;
        } else {
            output[count][j++] = user_input[k];
        }
    }
    return output;
}
