package RangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeUpdateQueries {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int q = nextInt();
        int op, p1, p2, p3, ai;
        array = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ai = nextInt();
            update(i, ai, n);
            update(i + 1, -ai, n);
        }

        while (q-- != 0) {
            op = nextInt();
            p1 = nextInt();
            if (op == 1) {
                p2 = nextInt();
                p3 = nextInt();
                update(p1 - 1, p3, n);
                update(p2, -p3, n);
            } else if (op == 2) {
                pw.println(sum(p1 - 1));
            }
        }
        pw.close();
    }

    private static long[] array;

    private static void update(int ind, int val, int n) {
        while (ind < n) {
            array[ind] += val;
            ind |= ind + 1;
        }
    }

    private static long sum(int k) {
        long res = 0;
        while (k >= 0) {
            res += array[k];
            k &= k + 1;
            k--;
        }
        return res;
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
