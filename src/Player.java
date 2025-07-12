public abstract class Player {
    private char disc;

    public Player(char disc) {
        this.disc = disc;
    }

    /**
     * Determines the column where the player wants to drop their disc
     *
     * @param board is the current state of the board
     * @return the column number chosen by the player as an int
     */
    public abstract int chooseColumn(IBoard board);

    /**
     * Retrieves the disc associated with this player.
     *
     * @return the character representing the player's disc
     */
    public char getDisc() {
        return disc;
    }
}
