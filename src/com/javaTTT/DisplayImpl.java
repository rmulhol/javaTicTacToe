package com.javaTTT;

import java.util.HashMap;

public class DisplayImpl extends Display {
    IO ioImpl;
    Messages messages;


    DisplayImpl(IO ioImpl, Messages messages) {
        this.ioImpl = ioImpl;
        this.messages = messages;
    }

    @Override
    void introduceGame() {
        ioImpl.printLine(messages.introduceGame());
    }

    @Override
    void getBoardSize() {
        ioImpl.printLine(messages.getBoardSize());
    }

    @Override
    void getPlayerIdentity(int i) {
        ioImpl.printLine(messages.getPlayerIdentity(i));
    }

    @Override
    void displayBoardWithIndexes(int boardSize) {
        ioImpl.printLine(messages.displayBoardWithIndexes(boardSize));
    }

    @Override
    void displayBoard(HashMap board) {
        ioImpl.printLine(messages.displayBoard(board));
    }

    @Override
    void announceWinForPlayer(String playerMove) {
        ioImpl.printLine(messages.announceWinForPlayer(playerMove));
    }

    @Override
    void announceTieGame() {
        ioImpl.printLine(messages.announceTieGame());
    }

    @Override
    void announceInputError() {
        ioImpl.printLine(messages.announceInputError());
    }

    @Override
    String getInput() {
        return ioImpl.getInput();
    }

    @Override
    int getValidInteger(String regex) {
        String integer = getInput();
        while (!integer.matches(regex)) {
            announceInputError();
            integer = getInput();
        }
        return Integer.parseInt(integer);
    }

}
