package medium;

import java.util.Arrays;

public class WordSearch79 {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        if(wordArr.length == 0) return false;
        //create 2D array of visited
        visited = new boolean [board.length] [board[0].length];
        for (boolean[] b : visited) {
            Arrays.fill(b, false);          
        }
        //find
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                //if the starting char is the same, start dfs from the next char
                if(board[row][col] == wordArr[0]) {
                    visited[row][col] = true;
                    if(dfs(board, row, col, wordArr, 1) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int row, int col, char[] wordArr, int idx) {
        System.out.println("row " + row + " col " + col + " idx " + idx);
        for (boolean[] b : visited) {
            for(boolean a : b) {
                System.out.print(a + " ");
            }          
            System.out.println();
        }
        System.out.println();
        //terminate when reaches the end of wordArr
        if (idx == wordArr.length) {
            return true;
        }
        //search in four directions
        if(row > 0 && row < board.length) { //up
            if(board[row - 1][col] == wordArr[idx] && !visited[row - 1][col]) {
                visited[row - 1][col] = true;
                if (dfs(board, row - 1, col, wordArr, idx + 1)) return true;                
            }
        }
        if (row < board.length - 1) { //down
            if(board[row + 1][col] == wordArr[idx] && !visited[row + 1][col]) {
                visited[row + 1][col] = true;
                if (dfs(board, row + 1, col, wordArr, idx + 1)) return true;
            }
        }
        if(col > 0 && col < board[row].length) { //left
            if(board[row][col - 1] == wordArr[idx] && !visited[row][col - 1]) {
                visited[row][col - 1] = true;
                if (dfs(board, row, col - 1, wordArr, idx + 1)) return true;                
            }
        }
        if (col < board[row].length - 1) { //right
            if(board[row][col + 1] == wordArr[idx] && !visited[row][col + 1]) {
                visited[row][col + 1] = true;
                if (dfs(board, row, col + 1, wordArr, idx + 1)) return true;                
            }
        }
        //clear just visited, not clear all visited
        visited[row][col] = false;
        return false;
    }
    public static void main(String[] args) {

    }

}
