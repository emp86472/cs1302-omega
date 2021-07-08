package cs1302.omega;

import java.util.Scanner;
import javafx.scene.image.Image;
/**
 * Represents a game of chess!
 */
public class ChessGame {

    private GamePiece[][] chessBoard;
    //begins true, white goes first.
    private boolean whitesTurn = true;
    private GamePiece selection;
    private boolean isInCheck;
    private String setUpSeed = "4 3 2 5 6 2 3 4 " +
                               "1 1 1 1 1 1 1 1 " +
                               "0 0 0 0 0 0 0 0 " +
                               "0 0 0 0 0 0 0 0 " +
                               "0 0 0 0 0 0 0 0 " +
                               "0 0 0 0 0 0 0 0 " +
                               "7 7 7 7 7 7 7 7 " +
                               "10 9 8 11 12 8 9 10";

    /**
     * An instance of a game of chess.
     */
    public ChessGame() {
        chessBoard = new GamePiece[8][8];
        Scanner scanner = new Scanner(this.setUpSeed);
        //need to populate the board.
        for (int i = 0, k = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                GamePiece gamePiece = createGamePiece(scanner.nextInt());
                chessBoard[i][j] = gamePiece;
                if (gamePiece != null) {
                    gamePiece.setPos(i, j);
                } //if
            } //for
        } //for
    } //ChessGame

    private GamePiece createGamePiece(int n) {
        switch (n) {
        case 0:
            return null;
        case 1:
            return new Pawn("BLACK");
        case 2:
            return new Bishop("BLACK");
        case 3:
            return new Knight("BLACK");
        case 4:
            return new Rook("BLACK");
        case 5:
            return new Queen("BLACK");
        case 6:
            return new King("BLACK");
        case 7:
            return new Pawn("WHITE");
        case 8:
            return new Bishop("WHITE");
        case 9:
            return new Knight("WHITE");
        case 10:
            return new Rook("WHITE");
        case 11:
            return new Queen("WHITE");
        case 12:
            return new King("WHITE");
        } //switch
        return null;
    } //createGamePiece

    /**
     * Selects a GamePiece to be moved. Must provide location of GamePiece.
     */
    public void select(int x, int y) {
        this.selection = chessBoard[x][y];
    } //select

    /**
     * Returns the GamePiece selection.
     */
    public GamePiece getSelection() {
        return this.selection;
    } //getSelection

    /**
     * Sets selection to null.
     */
    public void clearSelection() {
        this.selection = null;
    } //clearSelection

    /**
     * Moves a selected GamePiece. Must provide destination.
     */
    public void move(int x, int y) {
        if (this.isValidMove(x, y)) {
            chessBoard[x][y] = selection;
            chessBoard[selection.getPosX()][selection.getPosY()] = null;
            selection.setPos(x, y);
            //After every successful move the selection will be cleared and
            //isWhitesTurn will be set to its opposite
            this.selection = null;
            System.out.println("Selection cleared!");
            if (this.whitesTurn) {
                this.whitesTurn = false;
            } else {
                this.whitesTurn = true;
            } //if
        } else {
            //making an invalid move will clear selection.
            this.selection = null;
            System.out.println("Invalid Move! Selection cleared.");
        } //if
    } //move

    /**
     * Return true if and only if it is whites turn, false otherwise.
     */
    public boolean isWhitesTurn() {
        return this.whitesTurn;
    } //isWhitesTurn

    /**
     *
     */
    public void setWhitesTurn(boolean b) {
        this.whitesTurn = b;
    } //setWhitesTurn

    /**
     * Returns true if the move is valid.
     * Things we need to be able to tell if a move is valid:
     * 1. the starting position
     * 2. the destination
     * 3. the type of GamePiece it is
     * 4. if the GamePiece is white or black
     * 5. if the friendly king is in check
     * 6. if there are pieces (friend or foe) blocking
     */
    private boolean isValidMove(int x, int y) {
        if (whitesTurn == selection.isWhite()) {
            if (selection.isValidMove(x, y)) {
                if (selection.isBlockable()) { //includes Queens, Bishops, and Rooks
                    if (this.isBlocked(x, y)) {
                        return false;
                    } else if (chessBoard[x][y] != null) {
                        if (selection.isWhite() == chessBoard[x][y].isWhite()) {
                            return false;
                        } //if
                    } //if
                } else { //includes Pawns, Knights, and Kings
                    if (chessBoard[x][y] != null) {
                        if (selection.isWhite() == chessBoard[x][y].isWhite()) {
                            return false;
                        }
                    } //if
                } //if
            } else {
                return false;
            } //if
        } else {
            return false;
        } //if
        return true;
    } //isValidMove

    private boolean isBlocked(int x, int y) {
        int xdispl = x - selection.getPosX();
        int ydispl = y - selection.getPosY();
        //up displacement
        if (xdispl < 0 && ydispl == 0) {
            for (int i = selection.getPosX() - 1; i > x; i--) {
                if (chessBoard[i][y] != null) {
                    return true;
                } //if
            } //for
        } //if
        //right displacement
        if (xdispl == 0 && ydispl > 0) {
            for (int i = selection.getPosY() + 1; i < y; i++) {
                if (chessBoard[x][i] != null) {
                    return true;
                } //if
            } //for
        } //if
        //down displacement
        if (xdispl > 0 && ydispl == 0) {
            for (int i = selection.getPosX() + 1; i < x; i++) {
                if (chessBoard[i][y] != null) {
                    return true;
                } //if
            } //for
        } //if
        //left displacement
        if (xdispl == 0 && ydispl < 0) {
            for (int i = selection.getPosY() - 1; i > y; i--) {
                if (chessBoard[x][i] != null) {
                    return true;
                } //if
            } //for
        } //if
        //diagonal displacements
        if (xdispl < 0 && ydispl > 0) {
            for (int i = selection.getPosX() - 1, j = selection.getPosY() + 1; i > x; i--, j++) {
                if (chessBoard[i][j] != null) {
                    return true;
                } //if
            }// for
        } //if
        if (xdispl > 0 && ydispl > 0) {
            for (int i = selection.getPosX() + 1, j = selection.getPosY() + 1; i < x; i++, j++) {
                if (chessBoard[i][j] != null) {
                    return true;
                } //if
            } //for
        } //if
        if (xdispl > 0 && ydispl < 0) {
            for (int i = selection.getPosX() + 1, j = selection.getPosY() - 1; i < x; i++, j--) {
                if (chessBoard[i][j] != null) {
                    return true;
                } //if
            } //for
        } //if
        if (xdispl < 0 && ydispl < 0) {
            for (int i = selection.getPosX() - 1, j = selection.getPosY() - 1; i > x; i--, j--) {
                if (chessBoard[i][j] != null) {
                    return true;
                } //if
            } //for
        } //if
        return false;
    } //scanUp

    /**
     * Returns the image of the GamePiece at a location on the board.
     */
    public Image getImage(int x, int y) {
        if (chessBoard[x][y] != null) {
            return chessBoard[x][y].getImage();
        }
        return new Image("file:resources/empty.png");
    } //getImage
} //ChessGame
