package GraphAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BuildingRoads {
    private static final long MOD = 1000000007;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static HashMap<Integer, ArrayList<Integer>> adj;
    private static boolean[] visited;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int m = nextInt();
        adj = new HashMap<>();
        visited = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            adj.put(i + 1, new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                r.add(i);
                dfs(i);
            }
        }
        pw.println(r.size() - 1);
        for (int i = 0; i < r.size() - 1; i++)
            pw.println(r.get(i) + " " + r.get(i + 1));
        pw.close();
    }

    private static void dfs(int u) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v);
            }
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
