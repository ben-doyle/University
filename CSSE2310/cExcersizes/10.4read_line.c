#include <stdio.h>
#include <stdlib.h>

char* read_line(FILE* file);

int main(int argc, char** argv)
{
    FILE* fp;
    fp = fopen("random","r");
    printf("%s\n", read_line(fp));
    return 0;
}

char* read_line(FILE* file){
    int CUR_MAX = 80;
    char* result = malloc(sizeof(char) * CUR_MAX);
    int position = 0;
    int next = 0;
    int count = 0;

    while (1) {
        next = fgetc(file);
        if (count == CUR_MAX){
            CUR_MAX += 80;
            count = 0;
            char* temp = malloc(sizeof(char) * CUR_MAX);
            temp = realloc(result, sizeof(char) * CUR_MAX);
            result = temp;
            free(temp);
        }
        if (next == EOF || next == '\n') {
            result[position] = '\0';
            return result;
        }
        result[position++] = (char) next;
        count++;
    }
}
