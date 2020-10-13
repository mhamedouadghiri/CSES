package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MoneySums {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        nextInt();
        int[] x = Arrays.stream(nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[100001];
        for (int v : x) {
            for (int i = dp.length - 1; i > 0; i--)
                if (dp[i] == 1)
                    dp[i + v] = 1;
            dp[v] = 1;
        }
        pw.println(Arrays.stream(dp).filter(i -> i == 1).count());
        for (int i = 0; i < dp.length; i++)
            pw.print(dp[i] == 1 ? i + " " : "");
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