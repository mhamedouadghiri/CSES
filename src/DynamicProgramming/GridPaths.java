package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GridPaths {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        String[][] grid = new String[n][n];
        for (int i = 0; i < n; i++)
            grid[i] = nextLine().split("");
        int[][] dp = new int[n][n];
        if (grid[0][0].equals("*")) {
            pw.println(0);
            pw.close();
            return;
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].equals("*"))
                    continue;
                if (i != 0)
                    dp[i][j] = (int) ((dp[i][j] + dp[i - 1][j]) % MOD);
                if (j != 0)
                    dp[i][j] = (int) ((dp[i][j] + dp[i][j - 1]) % MOD);
            }
        }
        pw.println(dp[n - 1][n - 1]);
        pw.close();
    }

    private static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    private static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }

    private static long nextLong() {
        return Long.parseLong(next());
    }

    private static double nextDouble() {
        return Double.parseDouble(next());
    }
}