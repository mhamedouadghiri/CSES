package IntroductoryProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        long cnt = 0;
        for (int i = 0; i < n; i++) list.add(scanner.nextInt());
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                cnt += list.get(i) - list.get(i + 1);
                list.set(i + 1, list.get(i));
            }
        }
        System.out.println(cnt);
    }
}
