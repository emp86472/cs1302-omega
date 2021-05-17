package cs1302.omega;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Just creating the scene, background + chess pieces infront.
 * It should ultimately look like a chess board, but not yet function
 */
public class ChessApp extends Application {

    private ChessBoard chessBoard;
    private Image whiteTile;
    private Image blackTile;
    private String setUpSeed;
    private Image whiteKing;

    /**
     * Constructs an {@code OmegaApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public ChessApp() {}

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        setupBoard();

        // setup scene
        VBox root = new VBox();
        root.getChildren().add(chessBoard);
        Scene scene = new Scene(root);

        // setup stage
        stage.setTitle("OmegaApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();
    } //start

    public void setupBoard() {
        this.chessBoard = new ChessBoard();
        this.whiteTile = new Image("file:resources/whiteTile.png");
        this.blackTile = new Image("file:resources/blackTile.png");
        this.whiteKing = new Image("file:resources/whiteKing.png");
        BackgroundImage black = new BackgroundImage(blackTile,
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        BackgroundSize.DEFAULT);
        BackgroundImage white = new BackgroundImage(whiteTile,
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        BackgroundSize.DEFAULT);
        for (int i = 0, k = 1, l = 1; i < 8; i++, l++) {
            if (l % 2 == 0) {
                k = 2;
            } else {
                k = 1;
            } //if
            for (int j = 0; j < 8; j++, k++) {
                if (k % 2 == 0) {
                    chessBoard.getHBox(i, j).setBackground(new Background(black));
                    chessBoard.getImageView(i, j).setImage(whiteKing);
                } else {
                    chessBoard.getHBox(i, j).setBackground(new Background(white));
                    chessBoard.getImageView(i, j).setImage(whiteKing);
                } //if
            } //for
        } //for
    } //setupBoard
} //ChessApp
