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
import java.util.Scanner;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

/**
 * Just creating the scene, background + chess pieces infront.
 * It should ultimately look like a chess board, but not yet function
 */
public class ChessApp extends Application {

    private ChessBoard chessBoard;
    private Image whiteTile = new Image("file:resources/whiteTile.png");
    private Image blackTile = new Image("file:resources/blackTile.png");
    private ChessGame game;
    private int i = 0;

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

    /**
     * Creates the GUI board and the actual board.
     */
    public void setupBoard() {
        this.chessBoard = new ChessBoard();
        this.game = new ChessGame();
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
                } else {
                    chessBoard.getHBox(i, j).setBackground(new Background(white));
                } //if
                chessBoard.getImageView(i, j).setImage(game.getImage(i, j));
                chessBoard.getHBox(i, j).setPos(i, j);
                setAction(chessBoard.getHBox(i, j));
            } //for
        } //for
    } //setupBoard

    public void updateBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard.getImageView(i, j).setImage(game.getImage(i, j));
            } //for
        } //for
    } //updateBoard

    private void setAction(Square s) {
        EventHandler<MouseEvent> ae = event -> {
            if (game.getSelection() == null) {
                game.select(s.getPosX(), s.getPosY());
                System.out.println("Piece selected!");
            } else if (game.getSelection().isWhite() == game.isWhitesTurn()) {
                game.move(s.getPosX(), s.getPosY());
                updateBoard();
            } else {
                game.clearSelection();
            } //if
            System.out.println("(" + s.getPosX() + ", " + s.getPosY() + ")");
        };
        s.setOnMouseClicked(ae);
    } //setAction
} //ChessApp
