/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4.classes.board;

import connect4.Connect4Exception;
import connect4.Connect4Listener;
import connect4.classes.piece.GraphicPiece;
import connect4.classes.piece.Piece;
import java.awt.Color;
import java.awt.GridLayout;

/**
 *
 * @author Angela
 */
public class GraphicBoard extends Board {

    private Color colorBoard;
    private Color colorEmpty;
    private Connect4Listener listener;

    private GraphicBoard(Connect4Listener listener, Color colorBoard, Color colorEmpty) throws Connect4Exception {
        super();
        this.listener = listener;
        this.colorBoard = colorBoard;
        this.colorEmpty = colorEmpty;
        restart();
    }

    public GraphicBoard(Connect4Listener listener) throws Connect4Exception {
        this(listener, Color.BLUE, Color.WHITE);
    }

    public Color getColorBoard() {
        return colorBoard;
    }

    public void setColorBoard(Color colorBoard) {
        this.colorBoard = colorBoard;
    }

    public Color getColorEmpty() {
        return colorEmpty;
    }

    public void setColorEmpty(Color colorEmpty) {
        this.colorEmpty = colorEmpty;
    }

    @Override
    public final void restart() {
        boardArray = new GraphicPiece[this.getBoardWidth()][this.getBoardHeight()];
        for (int x = 0; x < boardArray.length; x++) {
            for (int y = 0; y < boardArray[x].length; y++) {
                //starts a new Game() with graphic Pieces
                boardArray[x][y] = new GraphicPiece(listener);
            }
        }
    }

    public final void showBoard() {
        //gets number of columns and rows of board
        int height = getBoardHeight();
        int width = getBoardWidth();
        removeAll();
        setLayout(new GridLayout(height, width));
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                //checks if the piece it's viable to play
                boolean playablePiece = getFirstEmptyLine(x) == y && listener.getGame().isGameOccurring();
                boardArray[x][y].setPlayablePiece(playablePiece);
                GraphicPiece piece = new GraphicPiece((GraphicPiece) boardArray[x][y]);
                //save the x value in the name
                piece.setName(Integer.toString(x));
                if (playablePiece) {
                    piece.setColor((piece.getColor()));
                }
                add(piece);
            }
        }
        revalidate();
        repaint();
    }

    @Override
    public void play(Piece p, int x) throws Connect4Exception {
        if (!isColumnFull(x)) {
            int y = getFirstEmptyLine(x);
            boardArray[x][y] = (GraphicPiece) p;
        } else {
            throw new Connect4Exception(connect4.enums.Error.FULL);
        }

    }

}
