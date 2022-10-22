import SortingAlgorithms.InsertionSort;
import SortingAlgorithms.SelectionSort;
import SortingAlgorithms.ShellSort;
import edu.princeton.cs.algs4.In;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn((new FileInputStream("src/resources/integers.txt")));
        Integer[] arr = Arrays.stream(new In().readAllInts()).boxed().toArray(Integer[]::new);
        SelectionSort.sort(arr);
        InsertionSort.sort(arr);
        ShellSort.sort(arr);
    }
}

