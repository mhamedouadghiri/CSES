package SortingAndSearching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++)
            set.add(scanner.nextInt());
        System.out.println(set.size());
    }
}
