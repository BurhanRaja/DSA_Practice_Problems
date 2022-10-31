package com.Burhan;


public class Sudoku_Solver {
    public static void main(String[] args) {
        solve();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] sudoku = {{0, 0, 4, 5, 6, 0, 0, 0, 9},
{0, 5, 6, 0, 0, 0, 2, 0, 3},
{7, 8, 9, 3, 0, 4, 1, 0, 0},
{3, 0, 0, 0, 5, 0, 0, 7, 4},
{4, 6, 7, 0, 0, 0, 0, 2, 8},
{0, 0, 8, 0, 0, 2, 0, 6, 1},
{6, 2, 0, 8, 1, 0, 4, 0, 5},
{8, 0, 1, 9, 4, 0, 6, 0, 2},
{0, 4, 5, 0, 3, 0, 8, 1, 7}};
    static boolean solve() {
        int i = 0, j = 0;
        for (i = 0; i < sudoku.length; i++) {
            boolean flag = false;
            for (j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (i==sudoku.length && j==sudoku.length) {
            return true;
        }

        for (int n = 1; n <= sudoku.length; n++) {
            if (isSafe(i, j, n)) {
                sudoku[i][j] = n;
                if (solve()) {
                    return true;
                }
                sudoku[i][j] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int i, int j, int n) {
        for (int k = 0; k < sudoku.length; k++) {
            if (sudoku[k][j] == n || sudoku[i][k] == n) {
                return false;
            }
        }

        int s = (int) Math.sqrt(sudoku.length);
        int rs = i - (i%s);
        int cs = j - (j%s);

        for (int k = 0; k < s; k++) {
            for (int l = 0; l < s; l++) {
                if (sudoku[k+rs][l+cs] == n) {
                    return false;
                }
            }
        }

        return true;
    }
}