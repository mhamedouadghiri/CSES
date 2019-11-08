package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SumOfTwoValues {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int x = nextInt();
        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            list[i][0] = nextInt();
            list[i][1] = i + 1;
        }

        Arrays.sort(list, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int a = list[i][0], b = x - a;
            int j = Arrays.binarySearch(list, new int[]{b}, Comparator.comparingInt(v -> v[0]));
            if (j > 0 && j != i) {
                pw.write(list[i][1] + " " + list[j][1]);
                pw.close();
                return;
            }
        }
        pw.println("IMPOSSIBLE");
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
