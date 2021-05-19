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

/**
 * Just creating the scene, background + chess pieces infront.
 * It should ultimately look like a chess board, but not yet function
 */
public class ChessApp extends Application {

    private ChessBoard chessBoard;
    private Image whiteTile = new Image("file:resources/whiteTile.png");
    private Image blackTile = new Image("file:resources/blackTile.png");
    private String setUpSeed = "4 3 2 5 6 2 3 4 " +
                               "1 1 1 1 1 1 1 1 " +
                               "0 0 0 0 0 0 0 0 " +
                               "0 0 0 0 0 0 0 0 " +
                               "0 0 0 0 0 0 0 0 " +
                               "0 0 0 0 0 0 0 0 " +
                               "7 7 7 7 7 7 7 7 " +
                               "10 9 8 11 12 8 9 10";
    private Image[] pieceArray;
    private Image empty = new Image("file:resources/empty.png");
    private Image blackPawn = new Image("file:resources/blackPawn.png");
    private Image blackBishop = new Image("file:resources/blackBishop.png");
    private Image blackKnight = new Image("file:resources/blackKnight.png");
    private Image blackRook = new Image("file:resources/blackRook.png");
    private Image blackQueen = new Image("file:resources/blackQueen.png");
    private Image blackKing = new Image("file:resources/blackKing.png");
    private Image whitePawn = new Image("file:resources/whitePawn.png");
    private Image whiteBishop = new Image("file:resources/whiteBishop.png");
    private Image whiteKnight = new Image("file:resources/whiteKnight.png");
    private Image whiteRook = new Image("file:resources/whiteRook.png");
    private Image whiteQueen = new Image("file:resources/whiteQueen.png");
    private Image whiteKing = new Image("file:resources/whiteKing.png");

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
        Scanner scanner = new Scanner(this.setUpSeed);
        pieceArray = new Image[]{empty, blackPawn, blackBishop, blackKnight, blackRook,
                                 blackQueen, blackKing, whitePawn, whiteBishop, whiteKnight,
                                 whiteRook, whiteQueen, whiteKing};
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
                chessBoard.getImageView(i, j).setImage(pieceArray[scanner.nextInt()]);
            } //for
        } //for
    } //setupBoard
} //ChessApp
