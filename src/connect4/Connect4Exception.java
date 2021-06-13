/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import connect4.enums.Error;
import connect4.enums.Language;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Angela
 */
public class Connect4Exception extends Exception {

    private final Error error;

    public Connect4Exception(Error error) {
        super(error.getName());
        this.error = error;
    }

    public void showConsole() {
        System.out.println("Connect4 EXCEPTION : " + getMessage());
        printStackTrace();
    }

    public void showErrorDialog(Component obj, Language language) {
        //opens Dialog with Error
        String msg = error.toLanguage(language);
        JOptionPane.showMessageDialog(obj, msg, Error.ERROR.toLanguage(language), JOptionPane.ERROR_MESSAGE);
    }
}
