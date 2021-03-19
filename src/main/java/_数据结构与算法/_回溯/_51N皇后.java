package _数据结构与算法._回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _51N皇后
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _51N皇后 {
    /**
     * 解法1：回溯
     */
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board, n, 0);
        return res;
    }

    public void backtrack(boolean[][] board, int n, int t) {
        if (t == n) {
            List<String> temp = new ArrayList<>();
            for (boolean[] boardI : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean boardIJ : boardI) {
                    if (boardIJ) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, t, col)) {
                board[t][col] = true;
                backtrack(board, n, t + 1);
                board[t][col] = false;
            }
        }
    }

    public boolean isValid(boolean[][] board, int t, int col) {
        for (int i = 0; i < t; i++) {
            if (board[i][col]) {
                return false;
            }
            for (int j = 0; j < board.length ; j++) {
                if(board[i][j]){
                    if (Math.abs(t - i) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _51N皇后 instance = new _51N皇后();
        System.out.println(instance.solveNQueens(4));
    }
}
