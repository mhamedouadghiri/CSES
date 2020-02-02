package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class FibonacciNumbers {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(fib(nextLong()) % MOD);
        pw.close();
    }

    private static long fib(long n) {
        long[][] F = new long[][]{{1, 1}, {1, 0}};
        if (n == 0)
            return 0;
        pow(F, n - 1);
        return F[0][0];
    }

    private static void multiply(long[][] F, long[][] M) {
        long x = (F[0][0] * M[0][0]) % MOD + (F[0][1] * M[1][0]) % MOD;
        long y = (F[0][0] * M[0][1]) % MOD + (F[0][1] * M[1][1]) % MOD;
        long z = (F[1][0] * M[0][0]) % MOD + (F[1][1] * M[1][0]) % MOD;
        long w = (F[1][0] * M[0][1]) % MOD + (F[1][1] * M[1][1]) % MOD;
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    private static void pow(long[][] F, long n) {
        if (n == 0 || n == 1)
            return;
        long[][] M = new long[][]{{1, 1}, {1, 0}};
        pow(F, n / 2);
        multiply(F, F);
        if (n % 2 != 0)
            multiply(F, M);
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

    private static BigInteger nextBigInteger() {
        return new BigInteger(next());
    }
}