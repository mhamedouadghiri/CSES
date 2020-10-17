package StringAlgorithms;

import java.io.*;

public class LongestPalindrome implements Runnable {
    private void solve() throws IOException {
        String s = nextLine();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        for (int i = 0; i < n; i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#!");
        String modified = sb.toString();
        int len = modified.length();
        int[] P = new int[len];
        int c = 0, r = 0;
        for (int i = 1; i < len - 1; i++) {
            int mir = 2 * c - i;
            if (i < r) {
                P[i] = Math.min(r - i, P[mir]);
            }
            while (modified.charAt(i + 1 + P[i]) == modified.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if (i + P[i] > r) {
                c = i;
                r = i + P[i];
            }
        }
        int maxLen = 0, center = 0;
        for (int i = 1; i < len - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                center = i;
            }
        }
        pw.println(s.substring((center - 1 - maxLen) / 2, maxLen + (center - 1 - maxLen) / 2));
    }

    public static void main(String[] args) {
        new LongestPalindrome().run();
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
