/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4.classes.connect4game;

import connect4.Connect4Exception;
import connect4.classes.board.Board;
import connect4.classes.piece.Piece;
import connect4.enums.Error;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Angela
 */
public class Connect4Game implements Serializable {

    private static final long serialVersionUID = 20L;
    protected ArrayList<Piece> players = new ArrayList<>();
    protected Piece activePlayer;
    protected Board myBoard;
    boolean gameOccurring;

    public Connect4Game(Board myBoard, ArrayList<Piece> players) throws Connect4Exception {
        if (players.size() < 2) {
            throw new Connect4Exception(Error.NPLAYERS);
        }
        this.myBoard = myBoard;
        this.players = players;
        gameOccurring = false;
        restart();

    }

    public Connect4Game() throws Connect4Exception {
        this(new Board(), new ArrayList<>(List.of(new Piece("1"), new Piece("2"))));
    }

    public ArrayList<Piece> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Piece> players) throws Connect4Exception {
        if (players.size() < 2) {
            throw new Connect4Exception(Error.NPLAYERS);
        }
        this.players = players;
        restart();
    }

    public Piece getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Piece activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Board getMyBoard() {
        return myBoard;
    }

    public void setMyBoard(Board myBoard) {
        this.myBoard = myBoard;
    }

    public boolean isGameOccurring() {
        return gameOccurring;
    }

    public void setGameOccurring(boolean gameOcurring) {
        this.gameOccurring = gameOcurring;
    }

    public void restart() throws Connect4Exception {
        myBoard.restart();
        activePlayer = players.get((int) (Math.random() * players.size()));
    }

    public void changeActivePlayer() throws Connect4Exception {
        int indActivePlayer = players.lastIndexOf(activePlayer);
        //gets the index next to the actual one
        int indNextPlayer = indActivePlayer == players.size() - 1 ? 0 : indActivePlayer + 1;
        //change active player to next One
        activePlayer = players.get(indNextPlayer);

    }

    public void playPiece(int x) throws Connect4Exception {
        myBoard.play(activePlayer, x);
    }

    public void displayConsole() {
        System.out.println(myBoard.toString());
    }

    public final void playPieceConsole() throws Connect4Exception {
        Scanner kbw = new Scanner(System.in);
        System.out.println("Player " + activePlayer.getTxt());
        System.out.print("Column \t: ");
        int x = kbw.nextInt();
        myBoard.play(activePlayer, x);

    }

    public void playGameConsole() {
        displayConsole();
        while (true) {
            try {
                playPieceConsole();
                displayConsole();
                if (myBoard.isFull()) {
                    System.out.println("Draw");
                    break;
                }
                if (myBoard.isWinner(activePlayer)) {
                    displayConsole();
                    System.out.println("Winner = " + activePlayer.getTxt());
                    break;
                }
                changeActivePlayer();
            } catch (Connect4Exception ex) {
                ex.showConsole();
            }

        }
    }
}
