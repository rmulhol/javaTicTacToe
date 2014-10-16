package com.javaTTT;

/**
 * Created by robertmulholand on 10/16/14.
 */
public class BoardImpl extends Board {
    private int[] board = createEmptyBoard();
    private int counter = 0;

    @Override
    public int[] createEmptyBoard() {
        int[] newBoard = new int[9];
        for(int i=0; i<9; i++) {
            newBoard[i] = 0;
        }
        return newBoard;
    }

    @Override
    public int[] getBoard() {
        return board;
    }

    @Override
    public void addPlayerMove(String move) {
        int moveIndex = convertStringToIndex(move);
        counter++;
        board[moveIndex] = counter;
    }

    @Override
    boolean checkSpaceAvailability(String move) {
        int moveIndex = convertStringToIndex(move);
        return board[moveIndex] == 0;
    }

    @Override
    boolean gameOver() {
        boolean gameOver = false;
        if(xWins() || oWins()) {
            gameOver = true;
        }
        return gameOver;
    }

    private boolean isX(int index) {
        return board[index] != 0 && board[index] % 2 == 0;
    }

    private boolean isO(int index) {
        return board[index] % 2 == 1;
    }

    public boolean xWins() {
        boolean winX = false;
        for(int[] combination : winningCombinations) {
            int[] winningCombination = new int[3];
            int xChecker = 0;
            for(int index : combination) {
                if(isX(index)) {
                    winningCombination[xChecker] = 1;
                }
                xChecker++;
            }
            if(winningCombination[0] == 1 && winningCombination[1] == 1 && winningCombination[2] == 1) {
                winX = true;
            }
        }
        return winX;
    }

    public boolean oWins() {
        boolean winO = false;
        for(int[] combination : winningCombinations) {
            int[] winningCombination = new int[3];
            int oChecker = 0;
            for(int index : combination) {
                if(isO(index)) {
                    winningCombination[oChecker] = 1;
                }
                oChecker++;
            }
            if(winningCombination[0] == 1 && winningCombination[1] == 1 && winningCombination[2] == 1) {
                winO = true;
            }
        }
        return winO;
    }

    private int convertStringToIndex(String move) {
        return Integer.parseInt(move);
    }

    private int[][] winningCombinations = {
            { 0, 1, 2 },
            { 3, 4, 5 },
            { 6, 7, 8 },
            { 0, 3, 6 },
            { 1, 4, 7 },
            { 2, 5, 8 },
            { 0, 4, 8 },
            { 2, 4, 6 }
    };


}
