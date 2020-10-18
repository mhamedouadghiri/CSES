package TreeAlgorithms;

import java.io.*;

public class CompanyQueriesI implements Runnable {
    private void solve() throws IOException {
        int n = nextInt();
        int q = nextInt();
        int log = (int) Math.ceil(Math.log(n) / Math.log(2));
        int[][] dp = new int[n + 1][log + 1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = nextInt();
        }
        for (int i = 1; i < log; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j][i] = dp[dp[j][i - 1]][i - 1];
            }
        }
        while (q-- != 0) {
            int x = nextInt();
            int k = nextInt();
            for (int i = 0; i <= log; i++) {
                if ((k & (1 << i)) != 0) {
                    x = dp[x][i];
                    if (x == 0) {
                        break;
                    }
                }
            }
            pw.println(x == 0 ? -1 : x);
        }
    }

    public static void main(String[] args) {
        new CompanyQueriesI().run();
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
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
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
