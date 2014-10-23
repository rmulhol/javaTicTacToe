package com.javaTTT;

import java.util.HashMap;

import static java.lang.Math.sqrt;

public class MessagesImpl extends Messages {

    @Override
    String introduceGame() {
        return "Hello. Welcome to tic tac toe!" + "\n" +
        "By default, this game is set to run HvC with a 3x3 board." + "\n" +
        "Would you like to modify these settings? (y/n)." + "\n";
    }

    // arbitrary capping board size at 9x9 but can run bigger w/ change to regex in config
    @Override
    String getBoardSize() {
        return "What do you want the side length of the board to be? (enter any number between 3 and 9)";
    }

    @Override
    String getPlayerIdentity(int i) {
        return "What will be the identity of player " + i + "?" + "\n" +
                "Enter 1 for human player, 2 for dumb ai player, or 3 for less dumb ai player.";
    }

    @Override
    String displayBoardWithIndexes(int boardSize) {
        return "For the game you've chosen, the board will be indexed as follows" + "\n" +
                boardWithIndexes(boardSize) + "\n" +
                "Let's get started!";
    }

    @Override
    String boardWithIndexes(int boardSize) {
        int boardSideLength = (int) sqrt(boardSize);
        String boardIndexes = boardLine(boardSideLength);
        for(int i=0; i<boardSize; i++) {
            if(i > 9) {
                boardIndexes += "| " + i + " ";
            } else {
                boardIndexes += "|  " + i + " ";
            }
            if (i % boardSideLength == boardSideLength - 1) {
                boardIndexes += "|";
                boardIndexes += boardLine(boardSideLength);
            }
        }
        return boardIndexes;
    }

    @Override
    String displayBoard(HashMap boardHashMap) {
        int boardLength = boardHashMap.size();
        int boardSideLength = (int) sqrt(boardLength);
        String boardToDisplay = boardLine(boardSideLength);
        for(int i=0; i<boardLength; i++) {
            boardToDisplay += "|  " + boardHashMap.get(i) + " ";
            if (i % boardSideLength == boardSideLength - 1) {
                boardToDisplay += "|" + boardLine(boardSideLength);
            }
        }
        return boardToDisplay;
    }

    @Override
    String announceWinForPlayer(String playerMove) {
        return "Player " + playerMove + " wins the game! Thanks for playing!";
    }

    @Override
    String announceTieGame() {
        return "Tie game! Thanks for playing!";
    }

    @Override
    String boardLine(int boardSideLength) {
        String boardLine = "\n";
        for(int i=0; i<boardSideLength; i++) {
            boardLine += "|----";
        }
        boardLine += "|" + "\n";
        return boardLine;
    }

    @Override
    String announceInputError() {
        return "Invalid input! Please try again.";
    }

}
