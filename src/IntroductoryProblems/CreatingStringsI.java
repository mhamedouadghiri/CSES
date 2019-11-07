package IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class CreatingStringsI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String string = scanner.nextLine();
        permute("", string);
        pw.println(done.size());
        done.forEach(pw::println);
        pw.close();
    }

    private static TreeSet<String> done = new TreeSet<>();

    private static void permute(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            done.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
            }
        }
    }
}
