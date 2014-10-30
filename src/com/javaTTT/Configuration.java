package com.javaTTT;

public class Configuration {

    Display display;

    Configuration(Display display) {
        this.display = display;
    }

    public Runner chooseGameSetup() {
        introduceGame();
        offerCustomGameSettings();

        String userResponse = getInput();

        if(userWantsToModifyGameSettings(userResponse)) {
            return createCustomGame();
        } else {
            return createDefaultGame();
        }
    }

    boolean userWantsToModifyGameSettings(String modifySettings) {
        return modifySettings.matches("[yY][a-zA-Z]*");
    }

    private Runner createCustomGame() {
        Board board = createBoard();
        Player player1 = createPlayer(1, board);
        Player player2 = createPlayer(2, board);
        return new Runner(display, board, player1, player2);
    }

    private Runner createDefaultGame() {
        Board board = new BoardImpl(3);
        Player humanPlayer = new HumanPlayer(display, "X");
        Player smartAiPlayer = new UnbeatableAiPlayer(board, "O");
        return new Runner(display, board, humanPlayer, smartAiPlayer);
    }

    private Board createBoard() {
        display.getBoardSize();
        int boardSideLength = display.getValidInteger("[3-9]");
        return new BoardImpl(boardSideLength);
    }

    private Player createPlayer(int playerNumber, Board board) {
        int playerIdentity = getPlayerIdentity(playerNumber);
        String moveSignature = getPlayerMoveSignature(playerNumber);
        return assignPlayer(board, playerIdentity, moveSignature);
    }

    int getPlayerIdentity(int playerNumber) {
        display.getPlayerIdentity(playerNumber);
        return display.getValidInteger("[1-4]");
    }

    String getPlayerMoveSignature(int playerNumber) {
        display.getPlayerMoveSignature(playerNumber);
        String moveSignature = getInput();
        while(!moveSignature.matches("\\S")) {
            displayInputError();
            moveSignature = getInput();
        }
        return moveSignature;
    }


    private Player assignPlayer(Board board, int playerIdentifier, String moveSignature) {
        switch (playerIdentifier) {
            case 1:
                return new HumanPlayer(display, moveSignature);
            case 2:
                return new DumbAiPlayer(board, moveSignature);
            case 3:
                return new SmartAiPlayer(board, moveSignature);
            default:
                return new UnbeatableAiPlayer(board, moveSignature);
        }
    }

    void introduceGame() { display.introduceGame(); }

    void offerCustomGameSettings() { display.offerCustomSettings(); }

    String getInput() { return display.getInput(); }

    void displayInputError() { display.announceInputError(); }
}