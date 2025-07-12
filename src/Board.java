public class Board implements IBoard {
    private final int rowSize = 6;
    private final int columnSize = 7;
    private final char[][] board;

    public Board() {
        board = new char[rowSize][columnSize];
        setUpBoard();
    }

    /**
     * Obtains the current board
     *
     * @return the board as a 2D char array
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Retrieves the number of rows in the board
     *
     * @return the number of rows as an int which is 6 for this implementation
     */
    public int getRows() {
        return rowSize;
    }

    /**
     * Retrieves the number of columns in the board
     *
     * @return the number of columns as an int which is 7 for this implementation
     */
    public int getColumns() {
        return columnSize;
    }

    /**
     * Retrieves the character's position of the board based on the column and row
     *
     * @param row    is the row index in the board
     * @param column is a column index in the board
     * @return the board's position as char
     */
    public char getBoardPosition(int row, int column) {
        return board[row][column];
    }

    /**
     * Checks if there is an empty character in the column
     *
     * @param column is a column index in the board
     * @return true if the column has no more empty characters, false otherwise
     */
    public boolean isColumnFull(int column) {

        return board[0][column] != ' ';
    }

    /**
     * Checks if there is an empty character in the board
     *
     * @return true if the board has no more empty characters left, false otherwise
     */
    public boolean isBoardFull() {

        for (int column = 0; column < columnSize; column++) {
            if (!isColumnFull(column)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there are 4 of the current player's discs are in a horizontal row
     *
     * @param disc the current player's disc
     * @return true if 4  of current player's discs are in a horizontal row, false otherwise
     */
    public boolean checkHorizontalWin(char disc) {

        for (int row = 0; row < rowSize; row++) {
            int count = 0;
            for (int column = 0; column < columnSize; column++) {
                if (board[row][column] == disc) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }

        }
        return false;

    }

    /**
     * Checks if there are 4 of the current player's discs are in a vertical row
     *
     * @param disc the current player's disc
     * @return true if 4 of current player's discs are in a vertical row, false otherwise
     */
    public boolean checkVerticalWin(char disc) {

        for (int column = 0; column < columnSize; column++) {
            int count = 0;
            for (int row = 0; row < rowSize; row++) {
                if (board[row][column] == disc) {
                    count++;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there are 4 of the current player's discs in a diagonal line from left to right
     *
     * @param disc the current player's disc
     * @return true if 4 of current player's discs are in left to right diagonal line, false otherwise
     */
    public boolean checkDiagonalLeftToRightWin(char disc) {
        for (int row = 3; row < rowSize; row++) {
            for (int col = 0; col < columnSize - 3; col++) {
                if (board[row][col] == disc
                        && board[row - 1][col + 1] == disc
                        && board[row - 2][col + 2] == disc
                        && board[row - 3][col + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there are 4 of the current player's discs in a diagonal line from right to left
     *
     * @param disc the current player's disc
     * @return true if 4 of current player's discs are in right to left diagonal line, false otherwise
     */
    public boolean checkDiagonalRightToLeftWin(char disc) {
        for (int row = 0; row < rowSize - 3; row++) {
            for (int col = 0; col < columnSize - 3; col++) {
                if (board[row][col] == disc
                        && board[row + 1][col + 1] == disc
                        && board[row + 2][col + 2] == disc
                        && board[row + 3][col + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Places the current player's disc on the board
     *
     * @param disc the current player's disc
     * @return true if the current player's disc has been placed on the board, false otherwise
     */
    public boolean placeDisc(int column, char disc) {
        for (int i = rowSize - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = disc;
                return true;
            }
        }
        return false;

    }

    /**
     * The board is set back to its empty state
     */
    public void resetBoard() {
        setUpBoard();
    }

    /**
     * Sets up a 6 by 7 board char array of empty characters
     */
    private void setUpBoard() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                board[i][j] = ' ';
            }
        }
    }
}
