package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BookShop {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int x = nextInt();
        int[] h = Arrays.stream(nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s = Arrays.stream(nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[x + 1];
        for (int i = 0; i < n; i++) {
            for (int j = x; j >= 1; j--) {
                if (h[i] <= j)
                    dp[j] = Math.max(dp[j], dp[j - h[i]] + s[i]);
            }
        }
        pw.println(dp[x]);
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