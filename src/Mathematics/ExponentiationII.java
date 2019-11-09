package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExponentiationII {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        long n = nextLong();
        while (n-- != 0)
            pw.println(pow(nextLong(), pow(nextLong(), nextLong(), MOD - 1), MOD));
        pw.close();
    }

    private static final int MOD = 1000000007;

    private static long pow(long a, long b, long mod) {
        long result = 1;
        while (b != 0) {
            if ((b & 1) != 0)
                result = (result * a) % mod;
            b >>= 1;
            a = (a * a) % mod;
        }
        return result;
    }

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

    private static long nextLong() {
        return Long.parseLong(next());
    }
}
