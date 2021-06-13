/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4.classes.board;

import connect4.Connect4Exception;
import connect4.classes.piece.Piece;
import connect4.enums.Error;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author Angela
 */
public class Board extends JPanel implements Serializable {

    private static final long serialVersionUID = 210L;
    protected Piece[][] boardArray;
    private int numPiecesWin;

    public Board(int width, int height, int numPiecesWin) throws Connect4Exception {
        setBoardSize(width, height);
        setNumPiecesWin(numPiecesWin);

    }

    public Board(Piece[][] boardArray, int numPiecesWin) throws Connect4Exception {
        this.boardArray = boardArray;
        this.numPiecesWin = numPiecesWin;
    }

    public Board() throws Connect4Exception {
        this(7, 6, 4);
    }

    public int getNumPiecesWin() {
        return numPiecesWin;
    }

    public final void setNumPiecesWin(int numPiecesWin) throws Connect4Exception {
        //verify if it's a viable number of pieces needed to win
        if (getBoardWidth() < numPiecesWin || getBoardHeight() < numPiecesWin) {
            throw new Connect4Exception(Error.SIZE);
        }
        this.numPiecesWin = numPiecesWin;
    }

    public int getBoardWidth() {
        return boardArray.length;
    }

    public int getBoardHeight() {
        return boardArray[0].length;
    }

    public Piece getPiece(int x, int y) {
        return boardArray[x][y];
    }

    public void setBoardArray(Piece[][] boardArray) {
        this.boardArray = boardArray;
    }

    public void setBoardSize(int width, int height) throws Connect4Exception {
        //verify if the board it's not too small
        if (width < 3 && height < 3) {
            throw new Connect4Exception(Error.SIZE);
        }
        //starts a new game with empty pieces
        boardArray = new Piece[width][height];
        for (int x = 0; x < boardArray.length; x++) {
            for (int y = 0; y < boardArray[x].length; y++) {
                boardArray[x][y] = new Piece();
            }
        }
    }

    public void restart() throws Connect4Exception {
        setBoardSize(getBoardWidth(), getBoardHeight());
    }

    public boolean isColumnFull(int x) {
        return !boardArray[x][getBoardHeight() - 1].isEmpty();
    }

    public int getFirstEmptyLine(int x) {
        //returns y of the first viable stop to put a piece in the column x
        int y = -1;
        for (int i = 0; i < boardArray[x].length; i++) {
            if (boardArray[x][i].isEmpty()) {
                y = i;
                break;
            }
        }
        return y;
    }

    public void play(Piece p, int x) throws Connect4Exception {
        //verify if x it's within bounds of board
        if (x < 0 || x >= boardArray.length) {
            throw new Connect4Exception(Error.COLUMN);
        }
        //verify if column is not full)
        if (!isColumnFull(x)) {
            int y = getFirstEmptyLine(x);
            boardArray[x][y] = p;
        } else {
            throw new Connect4Exception(Error.FULL);
        }
    }

    public boolean isFull() {
        //verify if whole board is full
        for (int x = 0; x < boardArray.length; x++) {
            for (int y = 0; y < boardArray[y].length; y++) {
                if (boardArray[x][y].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        //prints in console the gameBoard
        StringBuilder txt = new StringBuilder();
        for (int y = boardArray[0].length - 1; y >= 0; y--) {
            for (int x = 0; x < boardArray.length; x++) {
                txt.append(" ").append(boardArray[x][y].getTxt()).append(" ");
            }
            txt.append("\n");
        }
        return txt.toString();
    }

    public boolean isWinner(Piece p) {
        return checkHorizontal(p) || checkVertical(p) || checkDiagonal(p);
    }

    //checks if there is a win in line
    private boolean checkHorizontal(Piece p) {
        int count = 0;
        for (int y = 0; y < getBoardHeight(); y++) {
            count = 0;
            for (int x = 0; x < getBoardWidth(); x++) {
                if (boardArray[x][y].equals(p)) {
                    //if it's equal to the piece
                    count++;
                } else {
                    //if it's different resets counter
                    count = 0;
                }
                if (count == numPiecesWin) {
                    return true;
                }
            }
        }
        return false;
    }

    //checks if there is a win in xolumn
    private boolean checkVertical(Piece p) {
        int count = 0;
        for (int x = 0; x < getBoardWidth(); x++) {
            count = 0;
            for (int y = 0; y < getBoardHeight(); y++) {
                if (boardArray[x][y].equals(p)) {
                    //if it's equal to the piece
                    count++;
                } else {
                    //if it's different resets counter
                    count = 0;
                }
                if (count == numPiecesWin) {
                    return true;
                }
            }
        }
        return false;
    }

    //check all diagonals of board for a win
    private boolean checkDiagonal(Piece p) {
        int count = 0;
        for (int x = 0; x < getBoardWidth(); x++) {
            count = 0;
            for (int y = 0; y <= getBoardHeight(); y++) {
                //diagonal direction normal = -1 inverse = 1
                for (int d = -1; d <= 1; d += 2) {
                    count = 0;
                    int n = 0;
                    while (n < numPiecesWin) {
                        //checks if it's out of bounds
                        if (x + n * d < getBoardWidth() && y + n < getBoardHeight() && x + n * d >= 0) {
                            if (boardArray[x + (n * d)][y + n].equals(p)) {
                                //if it's equal to the piece
                                count++;
                            } else {
                                //if it's different resets counter
                                count = 0;
                            }
                            if (count == numPiecesWin) {
                                return true;
                            }
                        }
                        n++;

                    }
                }
            }
        }
        return false;
    }

}
