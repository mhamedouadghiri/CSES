package IntroductoryProblems;

import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long res = 1;
        final long MOD = 1000000007L;
        while (n-- != 0) {
            res <<= 1;
            res %= MOD;
        }
        System.out.println(res);
    }
}
