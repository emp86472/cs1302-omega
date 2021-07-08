package cs1302.omega;

/**
 * Represents a Knight in chess.
 */
public class Knight extends GamePiece {

    /**
     * Constructs an instance of a Knight GamePiece.
     */
    public Knight(String s) {
        super();
        this.setBlockable(false);
        this.setAlignment(s);
    } //Knight

    @Override
    public boolean isValidMove(int x, int y) {
        int xdispl = x - this.getPosX();
        int ydispl = y - this.getPosY();
        if (Math.abs(ydispl) == 2 && Math.abs(xdispl) == 1) {
            return true;
        } else if (Math.abs(xdispl) == 2 && Math.abs(ydispl) == 1) {
            return true;
        } //if
        return false;
    } //isValidMove

    @Override
    public void setAlignment(String s) {
        if (s.equals("WHITE")) {
            this.setWhite(true);
            this.setImage("file:resources/whiteKnight.png");
        } else if (s.equals("BLACK")) {
            this.setWhite(false);
            this.setImage("file:resources/blackKnight.png");
        } //if
    } //setAlignment
} //Knight
