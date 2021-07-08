package cs1302.omega;

import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Represents a square on the chessboard.
 * The square has a background, and holds the images of the chess
 * pieces.
 */
public class Square extends HBox {

    private int posX;
    private int posY;

    public Square() {
        super();
        //EventHandler<MouseEvent> ae = event -> {
        //    System.out.println("(" + this.posX + ", " + this.posY + ")");
        //};
        //this.setOnMouseClicked(ae);
    } //Square

    /**
     * Sets the position of the square.
     */
    public void setPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    } //setPos

    /**
     * Returns the X position of the Square
     */
    public int getPosX() {
        return this.posX;
    } //getPosX

    /**
     * Returns the Y position of the Square.
     */
    public int getPosY() {
        return this.posY;
    } //getPosY
} //Square
