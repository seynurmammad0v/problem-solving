package SortingAlgorithms;

import java.util.Arrays;

public class ShellSort extends SortingAlgorithm {
    public static <T> void sort(Comparable<T>[] arr) {
        Comparable<T>[] copy = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();
        sorting(copy);
        long endTime = System.nanoTime();
        System.out.printf("ShellSort sort execution time: %f \n", (endTime - startTime) / (float) 1_000_000_000);
    }

    private static <T> void sorting(Comparable<T>[] copy) {
        int N = copy.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(copy[j], copy[j - h]); j -= h) {
                    swap(copy, j, j - h);
                }
            }
            h = h / 3;
        }
        assert isSorted(copy);
    }
}
