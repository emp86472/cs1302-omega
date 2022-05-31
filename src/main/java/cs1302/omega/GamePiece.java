package cs1302.omega;

import javafx.scene.image.Image;

/**
 * Represents an abstract GamePiece in chess.
 */
public abstract class GamePiece {
    //the GamePiece's current position on the board
    private int posX;
    private int posY;
    private boolean isWhite;
    private boolean isBlockable;
    private String name;

    //the GamePiece's associated image
    private Image pieceImage;

    /**
     * Sets the new position of the GamePiece.
     * Used for initial position of GamePieces.
     */
    public void setPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    } //setPos

    /**
     * Returns the current X position of the GamePiece.
     */
    public int getPosX() {
        return this.posX;
    } //getPos

    /**
     * Returns the current Y position of the GamePiece.
     */
    public int getPosY() {
        return this.posY;
    } //getPosY

    /**
     * Sets the alignment of the GamePiece to be white or black.
     */
    public void setWhite(boolean b) {
        this.isWhite = b;
    } //setWhite

    /**
     * Returns the alignment of the GamePiece.
     */
    public boolean isWhite() {
        return isWhite;
    } //isWhite

    /**
     * Sets the name of the GamePiece.
     */
    public void setName(String s) {
        this.name = s;
    } //setName

    /**
     * Returns the name of the GamePiece.
     */
    public String getName() {
        return this.name;
    } //getName

    /**
     * Sets the image of the GamePiece
     */
    public void setImage(String png) {
        this.pieceImage = new Image(png);
    } //setImage

    /**
     * Returns the image associated with the GamePiece.
     */
    public Image getImage() {
        return this.pieceImage;
    } //getImage

    /**
     * Move this GamePiece to a different coordinate on the board.
     */
    public void move(int x, int y) {
        if (this.isValidMove(x, y)) {
            this.setPos(x, y);
        } //if
    } //move

    /**
     * Checks if the coordinate is valid within the bounds of the board and the
     * capabilites of the GamePiece.
     * Returns true if conditions are met.
     */
    public abstract boolean isValidMove(int x, int y);

    /**
     * Sets the color as well as the appopriate image associated to the color.
     */
    public abstract void setAlignment(String s);

    /**
     * Returns true if the GamePiece is blockable;
     */
    public boolean isBlockable() {
        return this.isBlockable;
    } //isBlockable

    /**
     * Sets blockable to true or false.
     */
    public void setBlockable(boolean b) {
        this.isBlockable = b;
    } //setBlockable
} //GamePiece
