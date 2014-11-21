package com.javaTTT;

import java.util.HashMap;

import static java.lang.Math.sqrt;

public class BoardImpl extends Board {

    BoardImpl(int sideLength) {
        boardSideLength = sideLength;
        boardSize = calculateBoardSizeFromSideLength(boardSideLength);
        board = createEmptyBoard(boardSize);
    }

    @Override
    int calculateBoardSizeFromSideLength(int boardSideLength) { return boardSideLength * boardSideLength; }

    @Override
    int calculateBoardSizeFromBoard(HashMap<Integer, String> board) {
        return board.size();
    }

    @Override
    int calculateBoardSideLengthFromBoard(HashMap<Integer, String> board) {
        int boardSize = calculateBoardSizeFromBoard(board);
        return (int) sqrt(boardSize);
    }

    @Override
    HashMap createEmptyBoard(int boardSize) {
        HashMap<Integer, String> myBoard = new HashMap<Integer, String>();
        for(int i=0; i<boardSize; i++) {
            myBoard.put(i, " ");
        }
        return myBoard;
    }

    @Override
    HashMap getBoard() { return board; }

    @Override
    void setMove(HashMap<Integer, String> board, int move, String player) { board.put(move, player); }

    @Override
    int[][] rows(int boardSideLength) {
        int[][] rows = new int[boardSideLength][boardSideLength];
        int counter = 0;
        for(int i=0; i<boardSideLength; i++) {
            for(int j=0; j< boardSideLength; j++) {
                rows[i][j] = counter++;
            }
        }
        return rows;
    }

    @Override
    int[][] columns(int boardSideLength) {
        int[][] columns = new int[boardSideLength][boardSideLength];
        int startingPosition = 0;
        int increment = 0;
        for(int i=0; i<boardSideLength; i++) {
            for(int j=0; j<boardSideLength; j++) {
                columns[i][j] = startingPosition + increment;
                increment += boardSideLength;
            }
            increment = 0;
            startingPosition += 1;
        }
        return columns;
    }

    @Override
    int[][] leftToRightDiagonal(int boardSideLength) {
        int[][] leftToRightDiagonal = new int[1][boardSideLength];
        int counter = 0;
        for(int i=0; i<boardSideLength; i++) {
            leftToRightDiagonal[0][i] = counter;
            counter += boardSideLength + 1;
        }
        return leftToRightDiagonal;
    }

    @Override
    int[][] rightToLeftDiagonal(int boardSideLength) {
        int[][] rightToLeftDiagonal = new int[1][boardSideLength];
        int counter = boardSideLength - 1;
        for(int i=0; i<boardSideLength; i++) {
            rightToLeftDiagonal[0][i] = counter;
            counter += boardSideLength - 1;
        }
        return rightToLeftDiagonal;
    }

    @Override
    public int[][] winningCombinations(int boardSideLength) {
        int[][] rows = rows(boardSideLength);
        int[][] columns = columns(boardSideLength);
        int[][] leftToRightDiagonal = leftToRightDiagonal(boardSideLength);
        int[][] rightToLeftDiagonal = rightToLeftDiagonal(boardSideLength);

        int rowsAndColumnsLength = rows.length + columns.length;
        int winningCombinationsLength = rowsAndColumnsLength + 2;

        int[][] winningCombinations = new int[winningCombinationsLength][boardSideLength];

        System.arraycopy(rows, 0, winningCombinations, 0, rows.length);
        System.arraycopy(columns, 0, winningCombinations, rows.length, columns.length);
        System.arraycopy(leftToRightDiagonal, 0, winningCombinations, rowsAndColumnsLength, 1);
        System.arraycopy(rightToLeftDiagonal, 0, winningCombinations, rowsAndColumnsLength+1, 1);

        return winningCombinations;
    }

    @Override
    boolean moveIsValid(HashMap<Integer, String> board, int move) {
        return spaceInRange(board, move) && spaceAvailable(board, move);
    }

    @Override
    boolean spaceAvailable(HashMap<Integer, String> board, int move) { return board.get(move).equals(" "); }

    @Override
    boolean spaceInRange(HashMap<Integer, String> board, int move) {
        int boardSize = calculateBoardSizeFromBoard(board);
        return move >= 0 && move <= boardSize - 1;
    }

    @Override
    boolean gameOver(HashMap<Integer, String> board, String player1Move, String player2move) {
        return playerWins(board, player1Move) || playerWins(board, player2move) || tieGame(board);
    }

    @Override
    boolean playerWins(HashMap<Integer, String> board, String playerMove) {
        int boardSideLength = calculateBoardSideLengthFromBoard(board);
        int[][] winningCombinations = winningCombinations(boardSideLength);
        boolean gameOver = false;
        for(int[] combination : winningCombinations) {
            int counter = 0;
            for(int space : combination ){
                if(board.get(space).equals(playerMove)) {
                    counter += 1;
                }
                if(counter == boardSideLength) {
                    gameOver = true;
                }
            }
        }
        return gameOver;
    }

    @Override
    boolean tieGame(HashMap<Integer, String> board) {
        int boardSize = calculateBoardSizeFromBoard(board);
        boolean gameOver = true;
        for(int i=0; i<boardSize; i++) {
            if(spaceAvailable(board, i)) {
                gameOver = false;
            }
        }
        return gameOver;
    }

}