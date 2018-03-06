package tut7;

public interface Piece {

    int MIN_ROW = 1;
    int MAX_ROW = 8;
    int MIN_COLUMN = 1;
    int MAX_COLUMN = 8;

    /**
     *  Returns whether a piece can move to a certain row/column.
     *
     *  @require 1 <= row <= 8 && 1 <= col <= 8
     *  @ensure returns true if the move is valid, false if it isn't.
     */
    boolean canMoveto(int row, int column);

    /**
     *  Moves the piece to the specified row/column.
     *
     *  @require 1 <= row <= 8 && 1 <= col <= 8
     *  @ensure If the move was valid, the piece's new position is (row, col).
     *          If the move is invalid, the piece stays in the same place.
     */
    void moveTo(int row, int column);
}
