package RangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeSumQueriesI {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int q = nextInt();
        long[] arr = new long[n];
        arr[0] = nextLong();
        for (int i = 1; i < n; i++)
            arr[i] = arr[i - 1] + nextLong();
        while (q-- != 0) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            pw.println(a != 0 ? arr[b] - arr[a - 1] : arr[b]);
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

    private static long nextLong() {
        return Long.parseLong(next());
    }
}
