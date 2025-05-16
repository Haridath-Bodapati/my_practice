package com.test;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudokuBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoko2(sudokuBoard)) {
        	System.out.println("Final Sudoko board.");
            printSudoku(sudokuBoard);
        } else {
            System.out.println("No solution exists.");
        }
    }
    


    /*private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {

                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            System.out.println("****** The row value is *********"+ (row+1));
                            System.out.println("****** The col value is *********"+ (col+1));
                            System.out.println("****** After changing value the board *********");
                        	printSudoku(board);
                            
                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }*/

    
    private static boolean solveSudoko(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                        	
                            board[row][col] = num;
                            
                            if (solveSudoko(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean solveSudoko2(int[][] board) {
    	
    	
    	return true;
    	
    }
    /* private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    } */
    
    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
        	if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        	if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }

        }
        return true;
    }

    private static void printSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

