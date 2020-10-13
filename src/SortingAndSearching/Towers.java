package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Towers {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        TreeMap<Integer, Integer> all = new TreeMap<>();
        while (n-- != 0) {
            int cube = nextInt();
            Integer high = all.higherKey(cube);
            if (high != null) {
                if (all.get(high) == 1)
                    all.remove(high);
                else
                    all.put(high, all.get(high) - 1);
            }
            all.put(cube, all.containsKey(cube) ? 1 + all.get(cube) : 1);
        }
        int nb = 0;
        for (int value : all.values())
            nb += value;
        pw.println(nb);
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