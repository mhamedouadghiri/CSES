package IntroductoryProblems;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        System.out.print(n + " ");
        while (n != 1) {
            if ((n & 1) == 0) n = n >> 1;
            else n = 3 * n + 1;
            System.out.print(n + " ");
        }
    }
}
