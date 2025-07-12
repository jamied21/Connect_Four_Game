import java.util.Random;

public class ComputerPlayer extends Player {
    private Random rand;

    public ComputerPlayer() {
        super('y');
        rand = new Random();
    }

    /**
     * Chooses a random column from the available columns on the board.
     *
     * @param board the current state of the game board
     * @return a randomly selected column number within the board's valid range as an int
     */
    @Override
    public int chooseColumn(IBoard board) {

        return rand.nextInt(board.getColumns());

    }
}
