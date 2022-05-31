package cs1302.omega;

/**
 * Represents a Rook in chess.
 */
public class Rook extends Queen {


    /**
     * Constructs an instance of a Rook GamePiece
     */
    public Rook(String s) {
        super(s);
        this.setName("rook");
        this.setAlignment(s);
    } //Rook

    @Override
    public boolean isValidMove(int x, int y) {
        if (this.isHorizontalMove(x, y)) {
            return true;
        } else if (this.isVerticalMove(x, y)) {
            return true;
        } //if
        return false;
    } //isValidMove

    @Override
    public void setAlignment(String s) {
        if (s.equals("WHITE")) {
            this.setWhite(true);
            this.setImage("file:resources/whiteRook.png");
        } else if (s.equals("BLACK")) {
            this.setWhite(false);
            this.setImage("file:resources/blackRook.png");
        } //if
    } //setAlignment
} //Rook
