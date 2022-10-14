package com.Burhan;

import java.util.Arrays;

public class Rat_in_a_Maze {
    public static void main(String[] args) {
        // int[][] arr = {
        //     {1, 1, 1, 1},
        //     {0, 0, 0, 1},
        //     {1, 1, 1, 1},
        //     {1, 0, 0, 0},
        //     {1, 1, 1, 1}
        // };

        // ratMaze(arr);

        sol = new int[maze.length][maze[maze.length-1].length];

        System.out.print(solveMaze());

    }

    static void ratMaze(int[][] arr) {
        int i = 0;
        int j = 0;

        String ans = "";

        arr[i][j] = -1;

        while (i < arr.length && j < arr[i].length) {
            if (i == arr.length-1 && j == arr[i].length-1) {
                break;
            }
            if (i <= arr.length-2 && arr[i+1][j] == 1) {
                arr[i+1][j] = -1;
                ans = "YES";
                i++;
            }
            else if (j <= arr[i].length-2 && arr[i][j+1] == 1) {
                arr[i][j+1] = -1;
                ans = "YES";
                j++;
            }
            else {
                ans = "NO";
                break;
            }
        }

        System.out.print(ans);
        System.out.println();
        for (int k = 0; k < arr.length; k++) {
            System.out.println(Arrays.toString(arr[k]));
        }
    }

    // Efficient
    static int[][] maze = {
            {1, 1, 1, 1},
            {0, 1, 0, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 0},
            {0, 0, 1, 1}
    };
    static int[][] sol;
    static boolean solveMaze() {
        if (solveMazeRec(0, 0) == false) {
            return false;
        }
        else {
            return true;
        }
    }
    static boolean solveMazeRec(int i, int j) {
        if (i == maze.length - 1 && j == maze[i].length - 1) {
            return true;
        }
        if (isSafe(i, j)) {
            sol[i][j] = 1;
            if (solveMazeRec(i+1, j) == true) {
                return true;
            }
            else if (solveMazeRec(i, j+1) == true) {
                return true;
            }
            else {
                sol[i][j] = 0;
            }
        }

        return false;
        
    }
    static boolean isSafe(int i, int j) {
        return i < maze.length && j < maze[i].length && maze[i][j] == 1;
    }
}
