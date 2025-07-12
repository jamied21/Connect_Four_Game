public interface IBoard {

    /**
     * Obtains the current board
     *
     * @return the board
     */
    char[][] getBoard();

    /**
     * Retrieves the number of rows in the board
     *
     * @return the number of rows as an int
     */
    int getRows();

    /**
     * Retrieves the number of columns in the board
     *
     * @return the number of columns as an int
     */
    int getColumns();

    /**
     * Retrieves the character's position of the board based on the column and row
     *
     * @param row    is the row index in the board
     * @param column is a column index in the boar
     * @return the board's position as char
     */
    char getBoardPosition(int row, int column);

    /**
     * Checks if there is space for disc to be placed in a column
     *
     * @param column is a column of the board
     * @return true if the column has no more space, false otherwise
     */
    boolean isColumnFull(int column);

    /**
     * Checks if there is space for disc to be placed in the board
     *
     * @return true if the board has no more space left, false otherwise
     */
    boolean isBoardFull();

    /**
     * Checks if there are x number of the current player's discs in a horizontal row
     *
     * @param disc the current player's disc
     * @return true if x number of current player's discs in a horizontal row, false otherwise
     */
    boolean checkHorizontalWin(char disc);

    /**
     * Checks if there are x number of the current player's discs in a vertical row
     *
     * @param disc the current player's disc
     * @return true if x number of current player's discs in a vertical row, false otherwise
     */
    boolean checkVerticalWin(char disc);

    /**
     * Checks if there are x number of the current player's discs in a diagonal line from left to right
     *
     * @param disc the current player's disc
     * @return true if x number of current player's discs in left to right diagonal, false otherwise
     */
    boolean checkDiagonalLeftToRightWin(char disc);

    /**
     * Checks if there are x number of the current player's discs in a diagonal line from right to left
     *
     * @param disc the current player's disc
     * @return true if x number current player's discs in right to left diagonal, false otherwise
     */
    boolean checkDiagonalRightToLeftWin(char disc);

    /**
     * Places the current player's disc on the board
     *
     * @param disc the current player's disc
     * @return true if the current player's disc has been placed on the board, false otherwise
     */
    boolean placeDisc(int column, char disc);

    /**
     * Clears the board
     */
    void resetBoard();
}

