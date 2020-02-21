package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BinomialCoefficients {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static long[] tab = new long[1000001];

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        tab[1] = 1;
        for (int i = 2; i < 1000001; i++)
            tab[i] = (tab[i - 1] * i) % MOD;
        int n = nextInt();
        while (n-- != 0) {
            int a = nextInt();
            int b = nextInt();
            long x = tab[a];
            long y = tab[b] * tab[a - b] % MOD;
            x *= modInverse(y, MOD);
            pw.println(x % MOD);
        }
        pw.close();
    }

    private static long modInverse(long a, long m) {
        return gcd(a, m) != 1 ? -1 : pow(a, m - 2, m);
    }

    private static long pow(long x, long y, long m) {
        if (y == 0)
            return 1;
        long p = pow(x, y / 2, m) % m;
        p = (p * p) % m;
        return y % 2 == 0 ? p : (x * p) % m;
    }

    private static long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
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