package com.javaTTT;

import java.util.HashMap;

import static java.lang.Math.sqrt;

public class BoardImpl extends Board {

    public BoardImpl(int size) {
        boardSize = size;
        boardLength = calculateBoardLength(boardSize);
        board = createEmptyBoard(boardLength);
    }

    @Override
    int calculateBoardLength(int boardSize) { return boardSize * boardSize; }

    @Override
    HashMap createEmptyBoard(int boardLength) {
        HashMap<Integer, String> myBoard = new HashMap<Integer, String>();
        for(int i=0; i<boardLength; i++) {
            myBoard.put(i, " ");
        }
        return myBoard;
    }

    @Override
    HashMap getBoard() { return board; }

    @Override
    void setMove(HashMap board, int move, String player) {
        board.put(move, player);
    }

    @Override
    boolean spaceAvailable(int move) {
        return board.get(move) == " ";
    }

    @Override
    int[][] rows(int boardSize) {
        int[][] rows = new int[boardSize][boardSize];
        int counter = 0;
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j< boardSize; j++) {
                rows[i][j] = counter++;
            }
        }
        return rows;
    }

    @Override
    int[][] columns(int boardSize) {
        int[][] columns = new int[boardSize][boardSize];
        int startingPosition = 0;
        int increment = 0;
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                columns[i][j] = startingPosition + increment;
                increment += boardSize;
            }
            increment = 0;
            startingPosition += 1;
        }
        return columns;
    }

    @Override
    int[][] leftToRightDiagonal(int boardSize) {
        int[][] leftToRightDiagonal = new int[1][boardSize];
        int counter = 0;
        for(int i=0; i<boardSize; i++) {
            leftToRightDiagonal[0][i] = counter;
            counter += boardSize + 1;
        }
        return leftToRightDiagonal;
    }

    @Override
    public int[][] rightToLeftDiagonal(int boardSize) {
        int[][] rightToLeftDiagonal = new int[1][boardSize];
        int counter = boardSize - 1;
        for(int i=0; i<boardSize; i++) {
            rightToLeftDiagonal[0][i] = counter;
            counter += boardSize - 1;
        }
        return rightToLeftDiagonal;
    }

    @Override
    public int[][] winningCombinations(int boardSize) {
        int[][] rows = rows(boardSize);
        int[][] columns = columns(boardSize);
        int[][] leftToRightDiagonal = leftToRightDiagonal(boardSize);
        int[][] rightToLeftDiagonal = rightToLeftDiagonal(boardSize);

        int rowsAndColumnsLength = rows.length + columns.length;
        int winningCombinationsLength = rowsAndColumnsLength + 2;

        int[][] winningCombinations = new int[winningCombinationsLength][boardSize];

        System.arraycopy(rows, 0, winningCombinations, 0, rows.length);
        System.arraycopy(columns, 0, winningCombinations, rows.length, columns.length);
        System.arraycopy(leftToRightDiagonal, 0, winningCombinations, rowsAndColumnsLength, 1);
        System.arraycopy(rightToLeftDiagonal, 0, winningCombinations, rowsAndColumnsLength+1, 1);

        return winningCombinations;
    }

    @Override
    public boolean playerWins(HashMap board, String playerMove) {
        int boardSize = findBoardSize(board);
        int[][] winningCombinations = winningCombinations(boardSize);
        boolean gameOver = false;
        for(int[] combination : winningCombinations) {
            int counter = 0;
            for(int space : combination ){
                if(board.get(space) == playerMove) {
                    counter += 1;
                }
                if(counter == boardSize) {
                    gameOver = true;
                }
            }
        }
        return gameOver;
    }

    @Override
    public boolean tieGame(HashMap board) {
        int boardLength = findBoardLength(board);
        boolean gameOver = true;
        for(int i=0; i<boardLength; i++) {
            if(spaceAvailable(i)) {
                gameOver = false;
            }
        }
        return gameOver;
    }

    @Override
    boolean gameOver(HashMap board, String player1Move, String player2move) {
        return playerWins(board, player1Move) || playerWins(board, player2move) || tieGame(board);
    }

    public int findBoardLength(HashMap board) {
        return board.size();
    }

    public int findBoardSize(HashMap board) {
        int boardLength = findBoardLength(board);
        return (int) sqrt(boardLength);
    }

}