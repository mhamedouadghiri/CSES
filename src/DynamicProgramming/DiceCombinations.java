package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiceCombinations {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int f : faces) {
                if (i - f >= 0) {
                    dp[i] = (dp[i] + dp[i - f]) % MOD;
                }
            }
        }
        pw.println(dp[n]);
        pw.close();
    }

    private static final int MOD = 1000000007;
    private static int[] faces = {1, 2, 3, 4, 5, 6};
    private static long[] dp = new long[1000001];

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

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