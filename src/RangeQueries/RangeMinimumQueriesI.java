package RangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeMinimumQueriesI {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int q = nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = nextInt();

        int[] logs = new int[n + 1];
        logs[1] = 0;
        for (int i = 2; i < n + 1; i++)
            logs[i] = logs[i / 2] + 1;

        // building sparse table
        int[][] table = new int[(int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1][n + 1];
        for (int i = 0; i <= logs[n]; i++) {
            int curLen = 1 << i;
            for (int j = 0; j + curLen < n + 1; j++) {
                if (curLen == 1) {
                    table[i][j] = array[j];
                } else {
                    table[i][j] = Math.min(table[i - 1][j], table[i - 1][j + curLen / 2]);
                }
            }
        }

        int a, b, p;
        while (q-- != 0) {
            a = nextInt() - 1;
            b = nextInt() - 1;
            p = logs[b - a + 1];
            pw.println(Math.min(table[p][a], table[p][b - (1 << p) + 1]));
        }
        pw.close();
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

    private static int nextInt() {
        return Integer.parseInt(next());
    }
}
