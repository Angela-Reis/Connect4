/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4.classes.piece;

import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author Angela
 */
public class Piece extends JLabel implements Serializable {

    private static final long serialVersionUID = 20L;
    protected static final String EMPTY = "?";
    protected String txt;
    private boolean playablePiece;

    public Piece(String txt, boolean playablePiece) {
        this.txt = txt;
        this.playablePiece = playablePiece;
    }

    public Piece(String txt) {
        this.txt = txt;
        playablePiece = false;
    }

    public Piece(Piece p) {
        this(p.txt, p.playablePiece);
    }

    public Piece() {
        this(EMPTY, false);
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public boolean isPlayablePiece() {
        return playablePiece;
    }

    public void setPlayablePiece(boolean playablePiece) {
        this.playablePiece = playablePiece;
    }

    public boolean isEmpty() {
        return txt.equals(EMPTY);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            return ((Piece) obj).txt.equals(this.txt);
        }
        return false;
    }

}
