package cs1302.omega;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessRow extends HBox {

    private ImageView[] imageViewArray;
    private HBox[] hBoxArray;

    /**
     * Constructs an instance of ChessRow. A ChessRow is an array
     * HBoxes that each contain an ImageView.
     */
    public ChessRow() {
        super();
        imageViewArray = new ImageView[8];
        hBoxArray = new HBox[8];
        for (int i = 0; i < imageViewArray.length; i++) {
            imageViewArray[i] = new ImageView();
            hBoxArray[i] = new HBox();
            hBoxArray[i].getChildren().add(imageViewArray[i]);
            this.getChildren().add(hBoxArray[i]);
        } //for
    } //ChessRow

    /**
     * Returns the HBox of the ChessRow at the given index.
     */
    public HBox getHBox(int index) {
        return this.hBoxArray[index];
    } //getHBox
    /**
     * Returns the ImageView of the ChessRow at the given index.
     */
    public ImageView getImageView(int index) {
        return this.imageViewArray[index];
    } //getImageView
} //ChessRow
