public class DisplayBoard {

    public DisplayBoard() {

    }

    /**
     * Displays the current state of the game board in the console
     * Red ('r') and Yellow ('y') discs are represented accordingly,
     * while empty spaces are displayed as '| '
     *
     * @param board the game board to be displayed
     */
    public void displayBoard(IBoard board) {

        for (int row = 0; row < board.getRows(); row++) {

            for (int column = 0; column < board.getColumns(); column++) {
                // Retrieve the character at the current position in the board
                char position = board.getBoardPosition(row, column);


                if (position == 'r') {
                    System.out.print("|r");
                } else if (position == 'y') {
                    System.out.print("|y");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" 0 1 2 3 4 5 6 ");
        System.out.println("---------------");
    }
}
