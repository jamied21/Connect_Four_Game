import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLogic {
    private IBoard board;
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;
    private DisplayBoard display;
    private Boolean gameOver = false;
    private BufferedReader br;

    public GameLogic(IBoard board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = playerOne;
        this.display = new DisplayBoard();
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Checks if the current player has won the game
     *
     * @return true if the current player has won, otherwise false
     */
    public boolean checkWinner() {
        char disc = currentPlayer.getDisc();
        return board.checkHorizontalWin(disc) || board.checkVerticalWin(disc)
                || board.checkDiagonalRightToLeftWin(disc) || board.checkDiagonalLeftToRightWin(disc);
    }

    /**
     * Switches the turn to the other player.
     */
    public void switchPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

    /**
     * Resets the game by clearing the board and setting the current player back to Player One
     */
    public void resetGame() {
        board.resetBoard();
        gameOver = false;
        currentPlayer = playerOne;
    }

    /**
     * Starts and manages the game loop, handling player moves, checking for wins, and handling game restarts
     */
    public void startGame() {
        do {
            resetGame();
            while (!gameOver) {
                display.displayBoard(board);
                int column = currentPlayer.chooseColumn(board); // Player makes a move

                // Place the disc
                if (board.placeDisc(column, currentPlayer.getDisc())) {
                    // Check for a winner or draw
                    if (checkWinner()) {
                        display.displayBoard(board);
                        System.out.println("Player " + currentPlayer.getDisc() + " wins!");
                        gameOver = true;
                    } else if (isDraw()) {
                        display.displayBoard(board);
                        System.out.println("The game is a draw!");
                        gameOver = true;
                    } else {
                        switchPlayer();
                    }
                }

            }
        } while (playAgain());
        System.out.println("Cheers for playing my game");
    }

    /**
     * Checks if the game has resulted in a draw
     *
     * @return true if the game is a draw, otherwise false
     */
    private boolean isDraw() {
        return !checkWinner() && board.isBoardFull();
    }

    /**
     * Asks the player if they would like to play another game.
     *
     * @return true if the player chooses to play again, otherwise false
     */
    private boolean playAgain() {
        String input;
        while (true) {
            System.out.print("Would you like to play again? (yes/no): ");
            try {
                input = br.readLine().trim().toLowerCase();
                if (input.equals("y") || input.equals("yes")) {
                    return true;
                }
                if (input.equals("n") || input.equals("no")) {
                    return false;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }

            } catch (IOException e) {
                System.out.println("Something went wrong. Exiting game.");
                return false;
            }
        }
    }
}
