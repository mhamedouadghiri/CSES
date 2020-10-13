package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FactoryMachines {
    private static final long MOD = 1000000007;
    private static final PrintWriter pw = new PrintWriter(System.out);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        int n = nextInt();
        int t = nextInt();
        Integer[] time = new Integer[n];
        for (int i = 0; i < n; i++) {
            time[i] = nextInt();
        }

        long low = 0;
        long high = Long.MAX_VALUE;
        long ans = 0;
        long mid;
        long sum;

        while (low <= high) {
            mid = (low + high) >> 1;
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum += mid / time[i];
                if (sum >= t) {
                    break;
                }
            }
            if (sum >= t) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        pw.println(ans);
        pw.close();
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
