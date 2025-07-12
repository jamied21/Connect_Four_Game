import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HumanPlayer extends Player {
    private BufferedReader br;

    public HumanPlayer() {
        super('r');
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Prompts the human player to enter a valid column number via the console
     * Provides console messages if the input is not a valid integer within the board's column range
     * and if that the selected column is full
     *
     * @param board the current state of the game board
     * @return the valid column number chosen by the player as int
     */
    @Override
    public int chooseColumn(IBoard board) {
        int column;

        while (true) {
            try {
                System.out.print("Enter a column between 0 and 6: ");
                String input;
                input = br.readLine().trim();

                column = Integer.parseInt(input);
                if (column >= 0 && column < board.getColumns() && !board.isColumnFull(column)) {
                    break;
                } else if (board.isColumnFull(column)) {
                    System.out.println("This column is already full. Please choose another one");
                } else {
                    System.out.println("Something went wrong. Try again");
                }

            } catch (IOException e) {
                System.out.println("Something went wrong. Try again");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please select a column between 0 and 6");
            }

        }
        return column;
    }
}
