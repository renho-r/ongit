package com.renho.solution;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P37 {

    @Test
    public void test() {
        char[][] testData = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(solveSudoku(testData));
    }

    public boolean solveSudoku(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if('.' == board[i][j]) {
                    for(char m='1'; m<='9'; m++) {
                        if(isValid(board, i, j, m)) {
                            board[i][j] = m;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for(int i=0; i<9; i++) {
            if('.'!=board[row][i] && num==board[row][i]) {
                return false;
            }
            if('.'!=board[i][col] && num==board[i][col]) {
                return false;
            }
            if('.'!=board[3*(row/3) + (i/3)][3*(col/3) + (i%3)] && num==board[3*(row/3) + (i/3)][3*(col/3) + (i%3)]) {
                return false;
            }
        }
        return true;
    }

}
