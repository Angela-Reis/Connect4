/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4.classes.piece;

import connect4.Connect4Listener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;

/**
 *
 * @author Angela
 */
public class GraphicPiece extends Piece implements MouseListener {

    private Color colorPiece;
    private Color colorOriginal;
    Connect4Listener listener;

    public GraphicPiece(Connect4Listener listener, String txt, Color colorPiece, boolean playablePiece) {
        super(txt, playablePiece);
        addMouseListener(this);
        this.colorPiece = colorPiece;
        this.listener = listener;
        colorOriginal = colorPiece;
        if (playablePiece) {
            alterColor();
            colorOriginal = colorPiece;
        }
    }

    public GraphicPiece(Connect4Listener listener) {
        this(listener, EMPTY, Color.WHITE, false);
    }

    public GraphicPiece(GraphicPiece p) {
        this(p.listener, p.txt, p.colorPiece, p.isPlayablePiece());
    }

    public Color getColor() {
        return colorPiece;
    }

    public void setColor(Color color) {
        this.colorPiece = color;
        colorOriginal = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //adapts size to the size of label
        int size = this.getWidth() <= this.getHeight() ? this.getWidth() : this.getHeight();
        int offsetCircle = 5;
        int circleSize = size - size / offsetCircle;
        int x = (size / offsetCircle) / 2;
        int y = (size / offsetCircle) / 2;
        g2d.setColor(colorPiece);
        g2d.fillOval(x, y, circleSize, circleSize);
        g2d.setColor(Color.BLACK);
        g.drawString(this.getText(), getWidth() / 2, getHeight() / 2);  // Draw the string.
        setVisible(true);

    }

    private void alterColor() {
        //use relative luminance to check if color is dark or light
        float luminance = (colorOriginal.getRed() * 0.2126f
                + colorOriginal.getGreen() * 0.7152f
                + colorOriginal.getBlue() * 0.0722f) / 255;
        //if it's a light color darken it and vice-versa
        if (luminance >= 0.5) {
            colorPiece = colorOriginal.darker();
        } else {
            colorPiece = colorOriginal.brighter();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        revalidate();
        if (this.isEmpty() && isPlayablePiece()) {
            //colorPiece = listener.getGame().getActivePlayer().getColor();
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            //repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //colorPiece = colorOriginal;
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        //repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (listener != null) {
            if (isPlayablePiece()) {
                //the x value of the piece was saved in the name in GraphicBoard
                listener.playListener(Integer.parseInt(this.getName()));
            } else if (!listener.getGame().isGameOccurring()) {
                listener.newGame();

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}
