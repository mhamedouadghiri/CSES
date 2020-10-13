package AdditionalProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountingBits {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static HashMap<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(foo(nextLong()));
        pw.close();
    }

    private static long foo(long n) {
        if (dp.get(n) != null) return dp.get(n);
        if (n == 0) return 0;
        if ((n & 1) == 0) {
            long x = foo(n >> 1) + foo((n >> 1) - 1) + (n >> 1);
            dp.put(n, x);
            return x;
        }
        long x = (foo(n >> 1) << 1) + (n >> 1) + 1;
        dp.put(n, x);
        return x;
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