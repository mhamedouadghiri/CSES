package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IncreasingSubsequence {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int[] A = Arrays.stream(nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = bs(dp, A[i]);
            if (dp[j - 1] < A[i] && A[i] < dp[j]) {
                dp[j] = A[i];
            }
        }
        int len = 0;
        for (int i = 0; i < n + 1; i++) {
            if (dp[i] < Integer.MAX_VALUE) {
                len = i;
            }
        }
        pw.print(len);
        pw.close();
    }

    private static int[] dp = new int[200002];

    private static int bs(int[] arr, int e) {
        int x = Arrays.binarySearch(arr, e);
        return x >= 0 ? x : -x - 1;
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