package Introducion;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String result = "";
        int count = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            count++;
            if (StdRandom.bernoulli((double) 1 / count)) {
                result = word;
            }
        }
        System.out.println(result);
    }
}
