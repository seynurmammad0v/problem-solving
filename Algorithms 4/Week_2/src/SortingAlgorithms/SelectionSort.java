package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort extends SortingAlgorithm {
    public static <T> void sort(Comparable<T>[] arr) {
        Comparable<T>[] copy = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();
        sorting(copy);
        long endTime = System.nanoTime();
        System.out.printf("Selection sort execution time: %f \n", (endTime - startTime) / (float) 1_000_000_000);
    }

    private static <T> void sorting(Comparable<T>[] copy) {
        int N = copy.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(copy[j], copy[min])) min = j;
            swap(copy, min, i);
        }
        assert isSorted(copy);

    }
}
