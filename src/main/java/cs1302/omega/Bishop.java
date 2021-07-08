package cs1302.omega;

/**
 * Represents a Bishop in chess.
 */
public class Bishop extends Queen {


    /**
     * Constructs an instance of a Bishop GamePiece
     */
    public Bishop(String s) {
        super(s);
        this.setAlignment(s);
    } //Bishop

    @Override
    public boolean isValidMove(int x, int y) {
        if (this.isDiagonalMove(x, y)) {
            return true;
        } //if
        return false;
    } //isValidMove

    @Override
    public void setAlignment(String s) {
        if (s.equals("WHITE")) {
            this.setWhite(true);
            this.setImage("file:resources/whiteBishop.png");
        } else if (s.equals("BLACK")) {
            this.setWhite(false);
            this.setImage("file:resources/blackBishop.png");
        } //if
    } //setAlignment
} //Bishop
