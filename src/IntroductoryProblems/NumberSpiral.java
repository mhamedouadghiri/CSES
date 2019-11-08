package IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class NumberSpiral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = scanner.nextInt();
        long y, x;
        while (t-- != 0) {
            y = scanner.nextLong();
            x = scanner.nextLong();
            pw.println((y < x) ? ((x & 1) == 0 ? x * x - 2 * x + y + 1 : x * x - y + 1) :
                    ((y & 1) == 0 ? y * y - x + 1 : y * y - 2 * y + x + 1));
        }
        pw.close();
    }
}
