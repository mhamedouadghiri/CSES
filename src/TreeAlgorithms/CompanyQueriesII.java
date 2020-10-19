package TreeAlgorithms;

import java.io.*;

public class CompanyQueriesII implements Runnable {
    private void solve() throws IOException {
        int n = nextInt();
        int q = nextInt();
        int log = (int) Math.ceil(Math.log(n) / Math.log(2));
        int[][] dp = new int[n + 1][log + 1];
        int[] lvl = new int[n + 1];
        lvl[1] = 0;
        for (int i = 2; i <= n; i++) {
            int x = nextInt();
            dp[i][0] = x;
            lvl[i] = 1 + lvl[x];
        }
        for (int i = 1; i < log; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j][i] = dp[dp[j][i - 1]][i - 1];
            }
        }
        while (q-- != 0) {
            int a = nextInt();
            int b = nextInt();
            if (lvl[a] < lvl[b]) {
                a ^= b;
                b ^= a;
                a ^= b;
            }
            for (int i = log; i >= 0; i--) {
                if (lvl[a] - (1 << i) >= lvl[b]) {
                    a = dp[a][i];
                }
            }
            if (b == a) {
                pw.println(b);
                continue;
            }
            for (int i = log; i >= 0; i--) {
                if (dp[b][i] != dp[a][i]) {
                    a = dp[a][i];
                    b = dp[b][i];
                }
            }
            pw.println(dp[b][0]);
        }
    }

    public static void main(String[] args) {
        new CompanyQueriesII().run();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.close();
    }

    private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final int BUFFER_SIZE = 1 << 16;
    private static final DataInputStream din = new DataInputStream(System.in);
    private static final byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;

    private static String nextLine() throws IOException {
        byte[] buf = new byte[(int) Math.pow(10, 7)];
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
