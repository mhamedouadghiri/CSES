package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountingDivisors {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                ++divs[j];
            }
        }
        int n = nextInt();
        while (n-- != 0) {
            pw.println(divs[nextInt()]);
        }
        pw.close();
    }

    private static final int MAX = 1000001;
    private static int[] divs = new int[MAX];

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