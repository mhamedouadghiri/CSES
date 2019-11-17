package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Apartments {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        List<Integer> applicants = new ArrayList<>();
        List<Integer> apartments = new ArrayList<>();
        for (int i = 0; i < n; i++)
            applicants.add(nextInt());
        for (int i = 0; i < m; i++)
            apartments.add(nextInt());
        Collections.sort(applicants);
        Collections.sort(apartments);
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m) {
            if (applicants.get(i) + k < apartments.get(j))
                ++i;
            else if (applicants.get(i) - k > apartments.get(j))
                ++j;
            else {
                ++i;
                ++j;
                ++cnt;
            }
        }
        pw.println(cnt);
        pw.close();
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

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