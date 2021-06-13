/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4.teste;

import connect4.Connect4Exception;
import connect4.classes.connect4game.Connect4Game;

/**
 *
 * @author Angela
 */
public class Connect4ConsoleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test classes
        try {
            System.out.println("Connect 4");
            Connect4Game game = new Connect4Game();
            game.playGameConsole();
            game.restart();
            game.playGameConsole();
        } catch (Connect4Exception ex) {
            ex.showConsole();
        }

    }

}
