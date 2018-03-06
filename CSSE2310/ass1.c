#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#include <inttypes.h>

int prevx; // previous x coord
int prevy; // previous y coord

int load_savegame(char* filename, int* height, int* width, char*** board,
        bool* currentPlayer, bool* loadedGame);
int check_arguments(int argc, char* argv[], int* height, int* width,
        char* playerType, char** filename, char*** board,
        bool* currentPlayer, bool* loadedGame);
int initialize_board(int* height, int* width, char*** board);
int draw_board(int* height, int* width, char** board);
int run_game(int* height, int* width, char** board, bool* currentPlayer,
        char** libBoard, char* playerType);
struct Coord computer_move(bool currentPlayer, int height, int width,
        int movecount);
char* read_line(FILE* file, int line);
int do_error(int error);
char* split_by_spaces(char* str);
int check_liberties(int* height, int* width, char** board, char player,
        char** libBoard);
int computerMove();
int save_game(int height, int width, char** board, char* filename,
        bool currentPlayer, int* movecount);
char** split_line(char userInput[100]);

struct Coord {
    int height;
    int width;
};

int main(int argc, char* argv[]) {

    int height; //Height of board
    int width; //Width of board
    char* playerType = malloc(sizeof(char) * 2);
    char* filename; //Filename
    char** board; //char array of board
    char** libBoard; //char array for recording liberties
    bool currentPlayer = 0;//Which player is up next
    bool loadedGame = false; //Has a file been loaded?

    //TODO add struct for game object
    check_arguments(argc, argv, &height, &width, playerType,
            &filename, &board, &currentPlayer, &loadedGame);
    if (!loadedGame) {
        initialize_board(&height, &width, &board);
        initialize_board(&height, &width, &libBoard);
    }
    draw_board(&height, &width, board);
    run_game(&height, &width, board, &currentPlayer, libBoard, playerType);
    return 1;
}


//Load the game from the filename
int load_savegame(char* filename, int* height, int* width, char*** board,
        bool* currentPlayer, bool* loadedGame) {
    *loadedGame = true;
    FILE* savegame = fopen(filename, "r");
    if (savegame == NULL) {
        return 4;
    }
    char* currentLine = malloc(sizeof(char) * 4095);
    char* line = malloc(sizeof(char) * 9);
    currentLine = read_line(savegame, 1);
    line = split_by_spaces(currentLine);
    *height = line[0];
    *width = line[1];
    *currentPlayer = line[2];
    free(line);
    free(currentLine);
    if (*height < 4 || *height > 1000 || *width < 4 || *width > 1000) {
        return 5;
    }
    char** b = malloc(sizeof(char*) * *height);
    for (int i = 0; i < *height; i++) {
        b[i] = malloc(sizeof(char) * *width);
    }

    for (int i = 0; i < *height; i++) {
        char* cl = malloc(sizeof(char) * 4095);
        cl = read_line(savegame, 1);
        for (int j = 0; j < *width; ++j) {
            if (cl[j] != 'O' && cl[j] != 'X' && cl[j] != '.') {
                do_error(5);
            }
            b[i][j] = cl[j];
        }

        *board = b;
        int number = strlen(cl);
        if (number < *width || number > *width) {
            return 5;
        }
        free(cl);
    }
    fclose(savegame);
    return 0;
}


//Check the arguments sent to program
int check_arguments(int argc, char* argv[], int* height, int* width,
        char* playerType, char** filename, char*** board, bool* currentPlayer,
        bool* loadedGame) {
    int error = 0;
    while (error == 0) {
        if (argc > 3 && argc <= 5) {
            if ((argv[1][0] == 'h' || argv[1][0] == 'c')
                    && argv[1][1] == '\0') {
                playerType[0] = argv[1][0];
            } else {
                error = 2;
                break;
            }
            if ((argv[2][0] == 'h' || argv[2][0] == 'c')
                    && argv[2][1] == '\0') {
                playerType[1] = argv[2][0];
            } else {
                error = 2;
                break;
            }
            if (argc == 4) {
                int len = strlen(argv[3]);
                *filename = malloc(len + 1);
                strcpy(*filename, argv[3]);
                do_error(load_savegame(*filename, height, width, board,
                        currentPlayer, loadedGame));

            }
            if (argc == 5) {
                *height = strtol(argv[3], NULL, 10);
                *width = strtol(argv[4], NULL, 10);
                if (*height < 4 || *height > 1000 || *width < 4 ||
                        *width > 1000) {
                    error = 3;
                    break;
                }
            }
        } else {
            error = 1;
            break;
        }
        if (error == 0) {
            error = 10;
        }
    }
    do_error(error);
    return 0;
}


// Takes an int as a number and exits using that code with message
int do_error(int error) {
    switch (error) {
        case 1:
            fprintf(stderr,
                    "Usage: nogo p1type p2type [height width | filename]\n");
            exit(1);
            break;
        case 2:
            fprintf(stderr, "Invalid player type\n");
            exit(2);
            break;
        case 3:
            fprintf(stderr, "Invalid board dimension\n");
            exit(3);
            break;
        case 4:
            fprintf(stderr, "Unable to open file\n");
            exit(4);
            break;
        case 5:
            fprintf(stderr, "Incorrect file contents\n");
            exit(5);
            break;
        case 6:
            fprintf(stderr, "End of input from user\n");
            exit(6);
            break;
        default:
            break;
    }
    return 0;
}


//initialize a board with all .
int initialize_board(int* height, int* width, char*** board) {

    char** b = malloc(sizeof(char*) * *height);
    for (int i = 0; i < *height; i++) {
        b[i] = malloc(sizeof(char) * *width);
    }

    for (int i = 0; i < *height; i++) {
        for (int j = 0; j < *width; j++) {
            b[i][j] = '.';
        }
    }
    *board = b;
    return 0;
}


//Draw the board, from file
int draw_board(int* height, int* width, char** board) {
    //Draw top
    printf("/");
    for (int i = 0; i < *width; i++) {
        printf("-");
    }
    printf("\\\n");

    for (int i = 0; i < *height; i++) {
        printf("|");
        for (int j = 0; j < *width; j++) {
            printf("%c", board[i][j]);
        }
        printf("|\n");
    }
    //Draw bottom
    printf("\\");
    for (int i = 0; i < *width; i++) {
        printf("-");
    }
    printf("/\n");
    return 0;
}


//run the game
int run_game(int* height, int* width, char** board, bool* currentPlayer,
        char** libBoard, char* playerType) {
    char player;
    bool game = true;
    int input;
    int* movecount = malloc(sizeof(int) * 2);
    movecount[0] = 0;
    movecount[1] = 0;
    char* line = malloc(sizeof(char) * 100);

    char** inputArr = malloc(sizeof(char*) * 4);
    for (int i = 0; i < 4; i++) {
        inputArr[i] = malloc(sizeof(char) * 100);
    }

    while (game) {
        free(line);
        char* line = malloc(sizeof(char) * 100);
        if (playerType[*currentPlayer] == 'h') {
            int count = 0;
            if(*currentPlayer == 0) {
                player = 'O';
            } else if (*currentPlayer == 1) {
                player = 'X';
            }

            printf("Player %c> ", player);
            while ((input = fgetc(stdin)) != '\n') {
                if (input == EOF) {
                    do_error(6);
                }
                line[count++] = input;
            }

            inputArr = split_line(line);

            if (inputArr[0][0] == 'w') {
                char* saveGameFile = malloc(sizeof(char) * 80);
                int count = 0;
                for (int i = 1; inputArr[0][i] != '\0'; ++i) {
                    saveGameFile[count] = inputArr[0][i];
                    count++;
                }
                saveGameFile[count++] = '\0';
                save_game(*height, *width, board, saveGameFile, currentPlayer,
                        movecount);
                continue;
            } else if (atoi(inputArr[0]) >= *height ||
                    atoi(inputArr[1]) >= *width ||
                    atoi(inputArr[0]) < 0 ||
                    atoi(inputArr[1]) < 0) {
                continue;
            } else if (atoi(inputArr[0]) <= *height &&
                    atoi(inputArr[1]) <= *width &&
                    atoi(inputArr[0]) >= 0 &&
                    atoi(inputArr[1]) >= 0) {
                if (board[atoi(inputArr[0])][atoi(inputArr[1])] == 'X' ||
                        board[atoi(inputArr[0])][atoi(inputArr[1])] == 'O') {
                    continue;
                }
                board[atoi(inputArr[0])][atoi(inputArr[1])] = player;
                check_liberties(height, width, board, player, libBoard);
                draw_board(height, width, board);
                *currentPlayer = !*currentPlayer;
            }
        } else if (playerType[*currentPlayer] == 'c') {
            if(*currentPlayer == 0) {
                player = 'O';
            } else {
                player = 'X';
            }
            struct Coord nextmove = computer_move(*currentPlayer, *height,
                    *width, movecount[(int) *currentPlayer]++);

            int x = nextmove.height;
            int y = nextmove.width;
            if (board[x][y] == 'X' || board[x][y] == 'O') {
                continue;
            }
            board[x][y] = player;
            printf("Player %c: %d %d\n", player, x, y);
            draw_board(height, width, board);
            *currentPlayer = !*currentPlayer;
        }
    }
    return 0;
}


//algoritim for computer move
struct Coord computer_move(bool currentPlayer, int height, int width,
        int movecount) {
    //Initital setu
    int n = 0;
    int x = 0;
    int y = 0;
    int r = 0;
    int c = 0;
    int ir = 0;
    if (currentPlayer == 0) {
        ir = 1;
    } else {
        ir = 2;
    }
    int ic;
    if (currentPlayer == 0) {
        ic = 4;
    } else {
        ic = 10;
    }
    int f;
    if (currentPlayer == 0) {
        f = 29;
    } else {
        f = 17;
    }
    int b;
    b = ir * width + ic;

    if (movecount == 0) {
        x = (ir % height);
        y = (ic % width);
        struct Coord move = {x,y};
        prevx = x;
        prevy = y;
        return move;
    } else {
        if (movecount % 5 == 0) {
            n = (b + movecount / 5 * f) % 1000003;
            r = n / width;
            c = n % width;
            x = (r % height);
            y = (c % width);
        } else if (movecount % 5 == 1) {
            r = prevx;
            c = prevy;
            r += 1;
            c += 1;
        } else if (movecount % 5 == 2) {
            r = prevx;
            c = prevy;
            r += 2;
            c += 1;
        } else if (movecount % 5 == 3) {
            r = prevx;
            c = prevy;
            r += 1;
        } else if (movecount % 5 == 4) {
            r = prevx;
            c = prevy;
            c += 1;
        }
    }
    x = (r % height);
    y = (c % width);
    prevx = x;
    prevy = y;
    struct Coord move = {x,y};
    return move;
}


//Read from file, one line at a time
char* read_line(FILE* file, int line) {
    char* result = malloc(sizeof(char) * 80);
    int position = 0;
    int next = 0;
    int count = 0;
    int thisLine = 1;

    while (thisLine <= line) {
        next = fgetc(file);
        if (next == '\n' && thisLine == line) {
            result[position] = '\0';
            return result;
        } else if (next == EOF) {
            result[position] = '\0';
            return result;
        }
        result[position++] = (char) next;
        count++;
    }
    return result;
}


//Split string input by space
char* split_by_spaces(char* str) {
    char* result = malloc(sizeof(int) * 1000);
    int count = 0;
    char* pch;
    pch = strtok(str, " ");
    while (pch != NULL) {
        result[count++] = atoi(pch);
        pch = strtok(NULL, " ");
    }
    return result;
}


//Check liberties on board
int check_liberties(int* height, int* width, char** board, char player,
        char** libBoard) {

    for (int i = 0; i < *height; i++) {
        for (int j = 0; j < *width; j++) {
            if (board[i][j] == '.') {
                continue;
            } else if (board[i][j] != player) {
                continue;
            } else {
                //Check north liberty
                if (i == 0) {
                    continue;
                } else if (board[i - 1][j] == '.') {
                    libBoard[i][j] = player; //has liberty
                }
                //Check east liberty
                if (j == *width) {
                    continue;
                } else if (board[i][j+1] == '.') {
                    libBoard[i][j] = player;
                }
                //check south liberty
                if (i == *height) {
                    continue;
                } else if (board[i-1][j] == '.') {
                    libBoard[i][j] = player;
                }
                //Check west liberty
                if (j == 0) {
                    continue;
                } else if (board[i][j-1] == '.') {
                    libBoard[i][j] = player;
                }
            }
        }
    }
    //draw_board(height, width, libBoard);
    return 0;
}


//Save the current game to file
int save_game(int height, int width, char** board, char* filename,
        bool currentPlayer, int* movecount) {
    FILE* outputFile = fopen(filename, "w");

    int xtemp = movecount[0];
    struct Coord onextmove = computer_move(currentPlayer, height, width,
            xtemp);
    int ox = onextmove.height;
    int oy = onextmove.width;

    int ytemp = movecount[1];
    struct Coord xnextmove = computer_move(currentPlayer, height, width,
            ytemp);
    int xx = xnextmove.height;
    int xy = xnextmove.width;


    fprintf(outputFile, "%d %d %d %d %d %d %d %d %d\n",
            height, width, (int) currentPlayer, ox, oy, movecount[0], xx, xy,
            movecount[1]);
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            fprintf(outputFile, "%c", board[i][j]);
        }
        fprintf(outputFile, "\n");
    }
    fflush(outputFile);
    return 0;

}


//Another split line function, this time into strings
char** split_line(char userInput[100]) {
    char** output = malloc(sizeof(char*) * 4);
    for (int i = 0; i < 4; i++) {
        output[i] = malloc(sizeof(char) * 25);
    }

    int count = 0;
    int j = 0;
    for (int k = 0; k < 100; ++k) {
        if (userInput[k] == '\n') {
            break;
        }
        if (userInput[k] == ' ') {
            count++;
            j = 0;
            continue;
        } else {
            output[count][j++] = userInput[k];
        }
    }
    return output;
}
