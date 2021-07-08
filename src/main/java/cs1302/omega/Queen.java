package cs1302.omega;

/**
 * Represents a Queen in chess.
 */
public class Queen extends GamePiece {

    /**
     * Constructs an instance of a Queen GamePiece.
     */
    public Queen(String s) {
        super();
        this.setBlockable(true);
        this.setAlignment(s);
    } //Queen

    @Override
    public boolean isValidMove(int x, int y) {
        if (this.isHorizontalMove(x, y)) {
            return true;
        } else if (this.isVerticalMove(x, y)) {
            return true;
        } else if (this.isDiagonalMove(x, y)) {
            return true;
        } //if
        return false;
    } //isValidMove

    public boolean isHorizontalMove(int x, int y) {
        if (x == this.getPosX() && y != this.getPosY()) {
            return true;
        }
        return false;
    } //

    public boolean isVerticalMove(int x, int y) {
        if (x != this.getPosX() && y == this.getPosY()) {
            return true;
        } //if
        return false;
    } //

    public boolean isDiagonalMove(int x, int y) {
        if (Math.abs(x - this.getPosX()) == Math.abs(y - this.getPosY())) {
            return true;
        } //if
        return false;
    } //

    @Override
    public void setAlignment(String s) {
        if (s.equals("WHITE")) {
            this.setWhite(true);
            this.setImage("file:resources/whiteQueen.png");
        } else if (s.equals("BLACK")) {
            this.setWhite(false);
            this.setImage("file:resources/blackQueen.png");
        } //if
    } //setAlignment
} //Queen
