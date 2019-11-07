package IntroductoryProblems;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long n = scanner.nextLong();
        long sum = n * (n + 1) >> 1;
        if ((sum & 1) != 0) pw.println("NO");
        else {
            pw.println("YES");
            long goal = sum / 2, sumA = 0;
            List<Long> A = new ArrayList<>();
            List<Long> B = new ArrayList<>();
            for (long i = n; i > 0; i--) {
                if (sumA + i <= goal) {
                    sumA += i;
                    A.add(i);
                } else {
                    B.add(i);
                }
            }
            pw.println(A.size());
            for (long e : A) pw.print(e + " ");
            pw.println("\n" + B.size());
            for (long e : B) pw.print(e + " ");
        }
        pw.close();
    }
}
