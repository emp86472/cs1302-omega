package cs1302.omega;

/**
 * Represents a Pawn in chess.
 */
public class Pawn extends GamePiece {

    /**
     * Constructs an instance of a Pawn GamePiece
     */
    public Pawn(String s) {
        super();
        this.setName("pawn");
        this.setBlockable(true);
        this.setAlignment(s);
    } //Pawn

    /**
     * Considers all possible moves a pawn can make.
     */
    @Override
    public boolean isValidMove(int x, int y) {
        if (this.isWhite()) {
            if (this.getPosX() - 1 == x && y >= this.getPosY() - 1 && y <= this.getPosY()
            || this.getPosX() - 2 == x && this.getPosY() == y) {
                return true;
            } //if
        } else {
            if (this.getPosX() + 1 == x && y >= this.getPosY() - 1 && y <= this.getPosY()
            || this.getPosX() + 2 == x && this.getPosY() == y) {
                return true;
            } //if
        } //if
        return false;
    } //isValidMove

    @Override
    public void setAlignment(String s) {
        if (s.equals("WHITE")) {
            this.setWhite(true);
            this.setImage("file:resources/whitePawn.png");
        } else if (s.equals("BLACK")) {
            this.setWhite(false);
            this.setImage("file:resources/blackPawn.png");
        } //if
    } //setAlignment
} //GamePiece
