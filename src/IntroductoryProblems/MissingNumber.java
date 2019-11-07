package IntroductoryProblems;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long sum = 0;
        for (int i = 0; i < n - 1; i++)
            sum += scanner.nextLong();
        System.out.println(n * (n + 1) / 2 - sum);
    }
}
