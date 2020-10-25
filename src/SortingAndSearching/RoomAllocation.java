package SortingAndSearching;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RoomAllocation implements Runnable {
    private void solve() throws IOException {
        int n = nextInt();
        Triplet[] master = new Triplet[n];
        for (int i = 0; i < n; i++) {
            master[i] = new Triplet(nextInt(), nextInt(), i);
        }
        Arrays.sort(master);
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        int totRooms = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int in = master[i].in;
            int out = master[i].out;
            int index = master[i].index;
            if (heap.isEmpty()) {
                ans[index] = ++totRooms;
                heap.add(new Pair(out, totRooms));
            } else {
                if (in > heap.peek().out) {
                    Pair poll = heap.poll();
                    ans[index] = poll.id;
                    heap.add(new Pair(out, poll.id));
                } else {
                    ans[index] = ++totRooms;
                    heap.add(new Pair(out, totRooms));
                }
            }
        }
        pw.println(totRooms);
        for (int i = 0; i < n; i++) {
            pw.print(ans[i] + " ");
        }
    }

    static class Triplet implements Comparable {
        int in;
        int out;
        int index;

        Triplet(int i, int o, int ind) {
            this.in = i;
            this.out = o;
            this.index = ind;
        }

        @Override
        public int compareTo(Object o) {
            if (((Triplet) o).in == in) {
                return Integer.compare(out, ((Triplet) o).out);
            }
            return Integer.compare(in, ((Triplet) o).in);
        }
    }

    static class Pair implements Comparable {
        int out;
        int id;

        Pair(int o, int i) {
            this.out = o;
            this.id = i;
        }

        @Override
        public int compareTo(Object o) {
            if (((Pair) o).out == out) {
                return Integer.compare(id, ((Pair) o).id);
            }
            return Integer.compare(out, ((Pair) o).out);
        }
    }

    public static void main(String[] args) {
        new RoomAllocation().run();
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
