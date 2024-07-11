package org.r7d.misc;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}
        };
        isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i< rows; i++) {
            Set<Character> pivot1 = new HashSet<>();
            if(board[i][0]!='.') pivot1.add(board[i][0]);
            Set<Character> pivot2 = new HashSet<>();
            if(board[0][i]!='.') pivot2.add(board[0][i]);
            for(int j= 1; j< cols;j++) {
                if(board[i][j]!='.' && pivot1.contains(board[i][j])) return false;
                if(board[j][i]!='.' && pivot2.contains(board[j][i])) return false;
                if(board[i][j]!='.') pivot1.add(board[i][j]);
                if(board[j][i]!='.') pivot2.add(board[j][i]);
            }
        }

        int horizontalBlockSwitch = 0;
        int verticalBlockSwitch = 0;
        while((horizontalBlockSwitch+3)<=cols && (verticalBlockSwitch+3)<=rows) {
            System.out.println("---horizontalBlockSwitch----" + horizontalBlockSwitch);
            System.out.println("---verticalBlockSwitch----" + verticalBlockSwitch);
            Set<Character> block = new HashSet<>();
            for(int i=verticalBlockSwitch; i< verticalBlockSwitch+3; i++) {
                for(int j=horizontalBlockSwitch; j< horizontalBlockSwitch+3;j++) {
                    System.out.print(board[i][j]  + " | ");
                    if(board[i][j]!='.' && block.contains(board[i][j])) return false;
                    if(board[i][j]!='.') block.add(board[i][j]);
                }
                System.out.println();
            }
            horizontalBlockSwitch+=3;
            if(horizontalBlockSwitch>=cols) {
                horizontalBlockSwitch = 0;
                verticalBlockSwitch += 3;
            }
        }
        return true;
    }
}
