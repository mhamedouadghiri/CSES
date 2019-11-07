package IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        int n = scanner.nextInt();
        if (n == 1) System.out.print(1);
        else if (n <= 3) printWriter.print("NO SOLUTION");
        else if (n == 4) printWriter.print("3 1 4 2");
        else {
            for (int i = 1; i <= n; i += 2) printWriter.print(i + " ");
            for (int i = 2; i <= n; i += 2) printWriter.print(i + " ");
        }
        printWriter.close();
    }
}