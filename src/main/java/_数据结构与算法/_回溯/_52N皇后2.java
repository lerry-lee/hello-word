package _数据结构与算法._回溯;


/**
 * @ClassName: _52N皇后2
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _52N皇后2 {
    int res;

    public int totalNQueens(int n) {
        res = 0;
        backtrack(new boolean[n][n], n, 0);
        return res;
    }

    public void backtrack(boolean[][] board, int n, int t) {
        if (t == n) {
            res++;
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
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]) {
                    if (Math.abs(t - i) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
