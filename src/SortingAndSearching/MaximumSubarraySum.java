package SortingAndSearching;

import java.util.Scanner;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) array[i] = scanner.nextInt();
        System.out.println(kadane(array));
    }

    private static long kadane(long[] arr) {
        long best = Long.MIN_VALUE, sum = 0;
        for (long e : arr) {
            sum = Math.max(sum + e, e);
            best = Math.max(best, sum);
        }
        return best;
    }
}
