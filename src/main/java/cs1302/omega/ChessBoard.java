package cs1302.omega;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;

public class ChessBoard extends VBox {

    private ChessRow[] chessBoard;

    /**
     * Constructs an instance of a ChessBoard. A ChessBoard is an array
     * of ChessRows.
     */
    public ChessBoard() {
        super();
        chessBoard = new ChessRow[8];
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[i] = new ChessRow();
            this.getChildren().add(chessBoard[i]);
        } //for
    } //ChessBoard

    /**
     * Returns the HBox of the ChessBoard at the given index.
     */
    public HBox getHBox(int row, int column) {
        return this.chessBoard[row].getHBox(column);
    } //getHBox

    /**
     * Returns the ImageView of the ChessBoard at the given index.
     */
    public ImageView getImageView(int row, int column) {
        return this.chessBoard[row].getImageView(column);
    } //getImageView
} //ChessBoard
