package RangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RangeSumQueriesII {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int q = nextInt();
        int op, p1, p2;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(nextLong());

        // construct bit tree
        List<Long> bit_tree = new ArrayList<>();
        for (int i = 1; i < n + 2; i++)
            bit_tree.add(0L);
        for (int i = 0; i < n; i++)
            updateBIT(bit_tree, i, list.get(i));

        while (q-- != 0) {
            op = nextInt();
            p1 = nextInt();
            p2 = nextInt();
            if (op == 1) {
                updateBIT(bit_tree, p1 - 1, p2 - list.get(p1 - 1));
                list.set(p1 - 1, (long) p2);
            } else if (op == 2)
                pw.println(sumQa_b(bit_tree, p1, p2));
        }
        pw.close();
    }

    private static void updateBIT(List<Long> bit_tree, int ind, long val) {
        ind++;
        while (ind < bit_tree.size()) {
            bit_tree.set(ind, bit_tree.get(ind) + val);
            ind += ind & -ind;
        }
    }

    private static long sumQ1_k(List<Long> bit_tree, int k) {
        long result = 0;
        while (k > 0) {
            result += bit_tree.get(k);
            k -= k & -k;
        }
        return result;
    }

    private static long sumQa_b(List<Long> bit_tree, int a, int b) {
        return sumQ1_k(bit_tree, b) - sumQ1_k(bit_tree, a - 1);
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
