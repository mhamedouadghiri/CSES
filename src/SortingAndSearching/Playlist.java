package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Playlist {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        Integer[] list = new Integer[n];
        for (int i = 0; i < n; i++) list[i] = nextInt();
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int max = 0;
        int j = 0;
        while (i < n) {
            if (!set.contains(list[i])) {
                set.add(list[i]);
            } else {
                max = Math.max(max, i - j);
                while (!list[i].equals(list[j])) {
                    set.remove(list[j]);
                    j++;
                }
                j++;
            }
            i++;
        }
        pw.println(Math.max(max, i - j));
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