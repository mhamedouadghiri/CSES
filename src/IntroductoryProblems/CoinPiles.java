package IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class CoinPiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = scanner.nextInt(), a, b;
        while (t-- != 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            pw.println((a + b) % 3 != 0 || Math.max(a, b) > 2 * Math.min(a, b) ? "NO" : "YES");
        }
        scanner.close();
        pw.close();
    }
}
