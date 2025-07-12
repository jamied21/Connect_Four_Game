public class Main {
    public static void main(String[] args) {

        Player human = new HumanPlayer();
        Player computer = new ComputerPlayer();
        Board board = new Board();
        GameLogic game = new GameLogic(board, human, computer);
        game.startGame();

    }
}
