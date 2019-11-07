package IntroductoryProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("");
        Map<String, Long> map = Arrays.stream(array).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Map<String, Long> odd = new HashMap<>();
        Map<String, Long> even = new HashMap<>();
        String oddLetter = "";
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0)
                even.put(entry.getKey(), entry.getValue());
            else if (entry.getValue() % 2 == 1) {
                odd.put(entry.getKey(), entry.getValue());
                oddLetter = entry.getKey();
            }
        }
        if (odd.size() > 1)
            System.out.println("NO SOLUTION");
        else {
            StringBuilder palindrome = new StringBuilder();
            StringBuilder partial = new StringBuilder();
            for (Map.Entry<String, Long> entry : even.entrySet())
                for (int i = 0; i < entry.getValue() / 2; i++)
                    partial.append(entry.getKey());
            palindrome.append(partial);
            if (!oddLetter.equals(""))
                palindrome.append(oddLetter.repeat(Math.toIntExact(odd.get(oddLetter))));
            palindrome.append(partial.reverse());
            System.out.println(palindrome);
        }
    }
}
