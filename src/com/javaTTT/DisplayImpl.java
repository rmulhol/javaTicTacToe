package com.javaTTT;

import java.util.HashMap;

public class DisplayImpl extends Display {
    IO ioImpl;
    Messages messages;
    Board board;


    DisplayImpl(IO ioImpl, Messages messages, Board board) {
        this.ioImpl = ioImpl;
        this.messages = messages;
        this.board = board;
    }


    @Override
    void introduceGame() {
        ioImpl.printLine(messages.introduceGame());
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
}
