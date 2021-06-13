package connect4.enums;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Angela
 */

//contains the languages
public enum Language {
    ENGLISH("English"), PORTUGUESE("Português");

    private final String name;

    private Language(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
