package IntroductoryProblems;

import java.util.Scanner;

public class TwoKnights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        for (long i = 1; i < n + 1; i++) {
            System.out.println((i - 1) * (i + 4) * (i * i - 3 * i + 4) / 2);
        }
    }
}
