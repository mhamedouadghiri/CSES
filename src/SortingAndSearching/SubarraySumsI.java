package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubarraySumsI {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int x = nextInt();
        int[] list = Arrays.stream(nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int j = 0, k = 0;
        long sum = 0, cnt = 0;
        while (j < n) {
            if (sum < x) {
                if (k >= n) break;
                sum += list[k];
                k++;
            }
            if (sum > x) {
                sum -= list[j];
                j++;
            }
            if (sum == x) {
                cnt++;
                sum -= list[j];
                j++;
            }
        }
        pw.println(cnt);
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