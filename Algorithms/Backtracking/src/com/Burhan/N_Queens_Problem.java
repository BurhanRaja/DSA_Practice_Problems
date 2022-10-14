package com.Burhan;

public class N_Queens_Problem {
    public static void main(String[] args) {
        board = new boolean[4][4];
        System.out.println(nQueens());
    }

    static boolean nQueens() {
        if (!nQueensRec(0)) {
            printBoard();
            return false;
        }
        else {
            printBoard();
            return true;
        }
    }

    static boolean[][] board; 
    static boolean nQueensRec(int col) {
        if (col == board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(i, col)) {
                board[i][col] = true;
                if (nQueensRec(col+1)) {
                    return true;
                }
                board[i][col] = false;
            }
        }
        return false;
    }

    static boolean isSafe(int row, int col) {
        // For the remaining column
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }

        // For diagonal top-left
        for (int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        
        // For diagonal bottom-left
        for (int i=row, j=col; j>=0 && i<board.length; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }

    static void printBoard() {
        int[][] arr = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
