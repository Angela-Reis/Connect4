package connect4.classes.connect4game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import connect4.Connect4Exception;
import connect4.Connect4Listener;
import connect4.classes.board.Board;
import connect4.classes.board.GraphicBoard;
import connect4.classes.piece.GraphicPiece;
import connect4.classes.piece.Piece;
import connect4.enums.Text;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Angela
 */
public class GraphicConnect4Game extends Connect4Game {

    private Connect4Listener listener;

    public GraphicConnect4Game(Connect4Listener listener) throws Connect4Exception {
        this.listener = listener;
        ArrayList<Piece> playersGraphic = new ArrayList<>(
                List.of(new GraphicPiece(listener, "1", Color.RED, false),
                        new GraphicPiece(listener, "2", Color.YELLOW, false)));
        setPlayers(playersGraphic);
        setMyBoard(new GraphicBoard(listener));
    }

    public GraphicConnect4Game(GraphicConnect4Game g) throws Connect4Exception {
        super(g.myBoard, g.players);
        this.listener = g.listener;
    }

    public GraphicConnect4Game(Connect4Listener listener, Board b,
            ArrayList<Piece> players, Piece activePlayer) throws Connect4Exception {
        super(b, players);
        this.activePlayer = activePlayer;
        this.listener = listener;
    }

    @Override
    public void playPiece(int x) throws Connect4Exception {
        super.playPiece(x);
        GraphicBoard board = (GraphicBoard) this.myBoard;
        board.showBoard();
        if (myBoard.isWinner(getActivePlayer())) {
            board.showBoard();
            gameOccurring = false;
            JOptionPane.showMessageDialog(
                    null, WinnerMessage(),
                    textToLanguage(Text.WINNER),
                    JOptionPane.INFORMATION_MESSAGE);
            listener.newGame();
        }
        if (board.isFull()) {
            gameOccurring = false;
            JOptionPane.showMessageDialog(
                    null, textToLanguage(Text.TIE));

        }
        changeActivePlayer();

    }

    private JPanel WinnerMessage() {
        //return a JPanel with the actual Player txt and graphic
        JPanel panel = new JPanel();
        JLabel label = new JLabel(textToLanguage(Text.WINNER) + " = " + getActivePlayer().getTxt());
        panel.setLayout(new GridLayout(2, 0));
        panel.add((GraphicPiece) activePlayer);
        panel.add(label);
        panel.setSize(100, 100);
        return panel;
    }

    private String textToLanguage(Text t) {
        return t.toLanguage(listener.getLanguage());
    }

    @Override
    public GraphicPiece getActivePlayer() {
        return (GraphicPiece) activePlayer;
    }

    //-----------------------------------------------------------------------------------------------
    //not working
    public void save(String fileName) throws FileNotFoundException, IOException, Connect4Exception {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
        output.writeObject(this);
        output.flush();
        output.close();

    }

    public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
        Connect4Game game = (Connect4Game) input.readObject();
        this.myBoard = game.myBoard;
        this.activePlayer = game.activePlayer;
        this.players = game.players;
    }
}
