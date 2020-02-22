package TreeAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Subordinates {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static HashMap<Integer, ArrayList<Integer>> direct = new HashMap<>();
    private static int[] result;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        result = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int c = nextInt();
            if (!direct.containsKey(c)) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                direct.put(c, al);
            } else {
                direct.get(c).add(i);
            }
        }
        dfs(1);
        for (int i = 1; i <= n; i++)
            pw.print(result[i] - 1 + " ");
        pw.close();
    }

    private static void dfs(int u) {
        result[u]++;
        if (!direct.containsKey(u))
            return;
        for (int v : direct.get(u)) {
            if (result[v] == 0)
                dfs(v);
            result[u] += result[v];
        }
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