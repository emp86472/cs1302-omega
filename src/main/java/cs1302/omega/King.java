package cs1302.omega;

/**
 * Represents a King in chess.
 */
public class King extends GamePiece {

    /**
     * Constructs an instance of a King GamePiece.
     */
    public King(String s) {
        super();
        this.setName("king");
        this.setBlockable(false);
        this.setAlignment(s);
    } //King

    @Override
    public boolean isValidMove(int x, int y) {
        int xdispl = x - this.getPosX();
        int ydispl = y - this.getPosY();
        if (Math.abs(xdispl) <= 1 && Math.abs(ydispl) <= 1) {
            return true;
        } //if
        return false;
    } //isValidMove

    @Override
    public void setAlignment(String s) {
        if (s.equals("WHITE")) {
            this.setWhite(true);
            this.setImage("file:resources/whiteKing.png");
        } else if (s.equals("BLACK")) {
            this.setWhite(false);
            this.setImage("file:resources/blackKing.png");
        } //if
    } //setAlignment
}
