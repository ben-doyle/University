package tut7;

public class Rook implements Piece {

    private int row;
    private int column;

    /**
     * Creates a new rook instance.
     */
    public Rook(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns whether a piece can move to a certain row/column.
     *
     * @require 1 <= row <= 8 && 1 <= col <= 8
     * @ensure returns true if the move is valid, false if it isn't.
     */
    @Override
    public boolean canMoveto(int row, int column) {
        if (row < 1 || row > 8 || column < 1 || column > 8) {
            return false;
        }

        if (this.row == row && this.column == column) {
            return false;
        }

        return (this.row == row ^ this.column == column);
    }

    /**
     * Moves the piece to the specified row/column.
     *
     * @require 1 <= row <= 8 && 1 <= col <= 8
     * @ensure If the move was valid, the piece's new position is (row, col).
     *          If the move is invalid, the piece stays in the same place.
     */
    @Override
    public void moveTo(int row, int column) {
        if (canMoveto(row, column)) {

            this.row = row;
            this.column = column;

        }
    }
}
