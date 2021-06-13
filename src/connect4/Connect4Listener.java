/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import connect4.classes.connect4game.GraphicConnect4Game;
import connect4.classes.piece.Piece;
import connect4.enums.Language;
import java.util.ArrayList;

/**
 *
 * @author Angela
 */
public interface Connect4Listener {

    public GraphicConnect4Game getGame();

    public void configureGame(int width, int height, int numPiecesWin);

    public void configurePlayers(ArrayList<Piece> players);

    public void playListener(int x);

    public Language getLanguage();

    public void newGame();

}
