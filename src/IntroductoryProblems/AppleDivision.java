package IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class AppleDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = scanner.nextInt();
        pw.println(minPartition(array, n - 1, 0, 0));
        pw.close();
    }

    private static long minPartition(int[] S, int n, long S1, long S2) {
        if (n < 0)
            return Math.abs(S1 - S2);
        long inc = minPartition(S, n - 1, S1 + S[n], S2);
        long exc = minPartition(S, n - 1, S1, S2 + S[n]);
        return Math.min(inc, exc);
    }
}