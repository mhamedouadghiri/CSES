package GraphAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MessageRoute {
    private static final long MOD = 1000000007;
    private static final PrintWriter pw = new PrintWriter(System.out);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static HashMap<Integer, LinkedList<Integer>> adj;
    private static boolean[] visited;
    private static Integer[] pred;
    private static LinkedList<Integer> path;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        adj = new HashMap<>();
        visited = new boolean[n + 1];
        pred = new Integer[n + 1];
        path = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj.put(i + 1, new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        if (!bfs(1, n)) {
            pw.println("IMPOSSIBLE");
        } else {
            setPath(n);
            pw.println(path.size());
            path.forEach(x -> pw.print(x + " "));
        }
        pw.close();
    }

    static boolean bfs(int s, int e) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            for (int i = 0; i < adj.get(s).size(); i++) {
                int v = adj.get(s).get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    pred[v] = s;
                    if (v == e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void setPath(int e) {
        int x = e;
        path.add(x);
        while (pred[x] != null) {
            path.add(pred[x]);
            x = pred[x];
        }
        Collections.reverse(path);
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
