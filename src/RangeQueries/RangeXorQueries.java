package RangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeXorQueries {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int q = nextInt();
        int a, b;
        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = nextInt();

        // construct segment tree
        int segTreeLen = 2 * nextPow2(n) - 1;
        int[] segTree = new int[segTreeLen];
        for (int i = 0; i < segTreeLen; i++)
            segTree[i] = Integer.MAX_VALUE;
        constructSegTree(segTree, list, 0, n - 1, 0);

        while (q-- != 0) {
            a = nextInt();
            b = nextInt();
            pw.println(rangeXorQuery(segTree, a - 1, b - 1, 0, n - 1, 0));
        }
        pw.close();
    }

    private static int rangeXorQuery(int[] segTree, int q_low, int q_high, int low, int high, int pos) {
        if (q_low <= low && q_high >= high)
            return segTree[pos];
        if (q_low > high || q_high < low)
            return 0;
        int mid = (low + high) / 2;
        return rangeXorQuery(segTree, q_low, q_high, low, mid, 2 * pos + 1) ^
                rangeXorQuery(segTree, q_low, q_high, mid + 1, high, 2 * pos + 2);
    }

    private static void constructSegTree(int[] segTree, int[] list, int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = list[low];
            return;
        }
        int mid = (low + high) / 2;
        constructSegTree(segTree, list, low, mid, 2 * pos + 1);
        constructSegTree(segTree, list, mid + 1, high, 2 * pos + 2);
        segTree[pos] = segTree[2 * pos + 1] ^ segTree[2 * pos + 2];
    }

    private static int nextPow2(int x) {
        int val = 1;
        while (val < x)
            val <<= 1;
        return val;
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
