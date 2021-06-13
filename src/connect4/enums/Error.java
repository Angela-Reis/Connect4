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

//contains the connect4Exception Errors
public enum Error {
    ERROR("error"),
    COLUMN("column"),
    LINE("line"),
    FULL("fullColumn"),
    SIZE("sizeBoard"),
    NPLAYERS("numPlayers");

    private final String name;

    private Error(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toLanguage(Language l) {
        switch (l) {
            case PORTUGUESE:
                return toPortuguese();
            default:
                return toEnglish();
        }
    }

    private String toPortuguese() {
        switch (this) {
            case ERROR:
                return "Erro";
            case COLUMN:
                return "Coluna invalida";
            case LINE:
                return "Linha invalida";
            case FULL:
                return "Coluna cheia";
            case SIZE:
                return "Dimensões Erradas";
            case NPLAYERS:
                return "Numero de Jogadores Errado";
            default:
                return "Erro Desconhecido";
        }
    }

    private String toEnglish() {
        switch (this) {
            case ERROR:
                return "Error";
            case COLUMN:
                return "Invalid Column";
            case LINE:
                return "Invalid Line";
            case FULL:
                return "Full Column";
            case SIZE:
                return "Wrong Dimensions";
            case NPLAYERS:
                return "Wrong Number of Players";
            default:
                return "Unknown Error";
        }
    }
}
