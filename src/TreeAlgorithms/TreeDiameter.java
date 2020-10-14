package TreeAlgorithms;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class TreeDiameter {
    private static final long MOD = 1000000007;
    private static final PrintWriter pw = new PrintWriter(System.out);

    private static HashMap<Integer, ArrayList<Integer>> adj;
    private static boolean[] visited;
    private static int middle;
    private static int maxLen;

    public static void main(String[] args) throws IOException {
        int n = nextInt();

        if (n == 1) {
            pw.println(0);
            pw.close();
            System.exit(0);
        }

        visited = new boolean[n + 1];
        adj = new HashMap<>();
        for (int i = 0; i < n; i++)
            adj.put(i + 1, new ArrayList<>());
        maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int a = nextInt();
            int b = nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1, 0);

        visited = new boolean[n + 1];

        dfs(middle, 0);

        pw.println(maxLen);
        pw.close();
    }

    private static void dfs(int u, int len) {
        visited[u] = true;
        len++;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (len >= maxLen) {
                    maxLen = len;
                    middle = v;
                }
                dfs(v, len);
            }
        }
    }

    private static final int BUFFER_SIZE = 1 << 16;
    private static final DataInputStream din = new DataInputStream(System.in);
    private static final byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;

    private static String readLine() throws IOException {
        byte[] buf = new byte[64];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.')
            while ((c = read()) >= '0' && c <= '9')
                ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        return buffer[bufferPointer++];
    }
}
