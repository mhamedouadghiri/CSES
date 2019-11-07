package IntroductoryProblems;

import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long cnt = 0, divisor = 5;
        while (n >= divisor) {
            cnt += n / divisor;
            divisor *= 5;
        }
        System.out.println(cnt);
    }
}
