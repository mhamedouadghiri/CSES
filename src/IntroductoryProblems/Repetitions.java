package IntroductoryProblems;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String seq = scanner.nextLine();
        int cnt = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < seq.length() - 1; i++) {
            if (seq.charAt(i) != seq.charAt(i + 1)) {
                if (cnt > max)
                    max = cnt;
                cnt = 1;
            } else cnt++;
        }
        System.out.println(Math.max(cnt, max));
    }
}
