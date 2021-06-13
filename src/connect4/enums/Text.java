/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4.enums;

/**
 *
 * @author Angela
 */
public enum Text {
    //all the text in the application
    LANGUAGE("Language"),
    WINNER("Winner"),
    TIE("Tie"),
    NEWGAME("New Game"),
    CONFIRM("Confirm"),
    CONFIRMNEWGAME("New Game"),
    SAVE("Save"),
    LOAD("Load"),
    RULES("Rules Game"),
    RULESTEXT("Text About Rules of Game"),
    ABOUT("About Game"),
    ABOUTTEXT("Text About Project"),
    EXIT("Exit"),
    CONFIRMEXIT("Exit Verification"),
    FILEEXISTING("File Exists"),
    CONFIRMOVERWRITE("Confirm File Overwrite"),
    SETTINGS("Settings"),
    CURRENTPLAYER("CurrentPlayer");

    private final String description;

    private Text(String description) {
        this.description = description;
    }

    public String toLanguage(Language l) {
        switch (l) {
            case PORTUGUESE:
                return toPortuguese();
            default:
                return toEnglish();
        }
    }

    private String toEnglish() {
        switch (this) {
            case LANGUAGE:
                return "Language";
            case WINNER:
                return "Winner";
            case TIE:
                return "The Game ended in a Tie";
            case NEWGAME:
                return "New Game";
            case CONFIRMNEWGAME:
                return "Start New Game ?";
            case SAVE:
                return "Save";
            case LOAD:
                return "Load";
            case RULES:
                return "Game Rules";
            case RULESTEXT:
                return "Connect 4 is a game, traditionally, played with 2 players \n"
                        + "on a 7x6 board. \n"
                        + "In each turn, a player places a token of their color on a \n"
                        + "column and it drops to the first available line.\n"
                        + "The player who first manages to place 4 tokens in a row \n"
                        + "of their color horizontally, vertically or diagonally wins.\n"
                        + "If no one gets four in a row, it ends in a draw.\n"
                        + "In this program you can customize the rules more, change the \n"
                        + "number of players the number of tokens needed to win \n"
                        + "and the size of the board";
            case ABOUT:
                return "About";
            case ABOUTTEXT:
                return "Game developed as the Final Project for the Object-Oriented\n"
                        + " Programming subject in the Computer Engineering course.\n"
                        + "\nName: Ângela Daniela Violante dos Reis \n"
                        + "Student Number : 20946 \n"
                        + "Class: 1º A \n"
                        + "Year: 2020/2021";
            case EXIT:
                return "Exit";
            case CONFIRMEXIT:
                return "Wish to Exit Apllication?";
            case FILEEXISTING:
                return "Existing File";
            case CONFIRMOVERWRITE:
                return "Overwrite Existing File?";
            case CONFIRM:
                return "Confirm";
            case SETTINGS:
                return "Settings";
            case CURRENTPLAYER:
                return "Current Player";
            default:
                return "Error: Unknow Text";
        }
    }

    private String toPortuguese() {
        switch (this) {
            case LANGUAGE:
                return "Linguagem";
            case WINNER:
                return "Vencedor";
            case TIE:
                return "O Jogo acabou num Empate";
            case NEWGAME:
                return "Novo Jogo";
            case CONFIRMNEWGAME:
                return "Começar novo jogo?";
            case SAVE:
                return "Guardar";
            case LOAD:
                return "Carregar";
            case RULES:
                return "Regras";
            case RULESTEXT:
                return "Quatro em Linha é um jogo que, tradicionalmente, joga-se com 2 \n"
                        + "jogadores num tabuleiro de 7x6. \n"
                        + "Em cada turno cada jogador coloca uma ficha da sua cor \n"
                        + "numacoluna e esta cai até à primeira linha disponível.\n"
                        + "O jogador que primeiro conseguir colocar 4 fichas da sua \n"
                        + "cor seguidas na horizontal, vertical ou diagonal ganha. \n"
                        + "Se ninguém conseguir a partida termina em empate. \n"
                        + "Neste programa dá para personalizar mais as regras, mudar \n"
                        + "o número de jogadores, o número de fichas necessárias para \n"
                        + "ganhar e o tamanho do tabuleiro";
            case ABOUT:
                return "Acerca";
            case ABOUTTEXT:
                return "Jogo desenvolvido como o Projeto Final da disciplina \n"
                        + "Programação Orientada a Objetos do curso de \n"
                        + "Engenharia Informática.\n"
                        + "\nNome: Ângela Daniela Violante dos Reis \n"
                        + "Número de Aluno : 20946 \n"
                        + "Turma: 1º A \n"
                        + "Ano: 2020/2021 ";
            case EXIT:
                return "Sair";
            case CONFIRMEXIT:
                return "Deseja Sair da Aplicação?";
            case FILEEXISTING:
                return "Ficheiro Existente";
            case CONFIRMOVERWRITE:
                return "Sobrescrever ficheiro existentes?";
            case CONFIRM:
                return "Confirmar";
            case SETTINGS:
                return "Definições";
            case CURRENTPLAYER:
                return "Jogador Atual";
            default:
                return "Erro: Texto Desconhecido";
        }
    }
}
