package IntroductoryProblems;

import java.util.Scanner;

public class ChessboardAndQueens {
    private static int N = 8;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[N][N];
        for (int i = 0; i < N; i++)
            board[i] = scanner.nextLine().split("");
        solve(board, 0);
        System.out.println(cnt);
    }

    private static boolean isSafe(String[][] board, int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i].equals("+"))
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j].equals("+"))
                return false;
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j].equals("+"))
                return false;
        return true;
    }

    private static boolean solve(String[][] board, int col) {
        if (col == N) {
            cnt++;
            return true;
        }
        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col) && !board[i][col].equals("*")) {
                board[i][col] = "+";
                res = solve(board, col + 1) || res;
                board[i][col] = ".";
            }
        }
        return res;
    }
}
