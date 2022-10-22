package SortingAlgorithms;


public class SortingAlgorithm {

    public static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    public static <T> void swap(Comparable<T>[] arr, int i, int j) {
        Comparable<T> t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static <T> void show(Comparable<T>[] arr) {
        for (Comparable<T> item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static <T> boolean isSorted(Comparable<T>[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (less(arr[i], arr[i - 1])) return false;
        return true;
    }

}
