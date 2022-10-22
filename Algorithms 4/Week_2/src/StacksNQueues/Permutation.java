package StacksNQueues;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        for (String s : rq) {
            if (k == 0) {
                break;
            }
            System.out.println(s);
            k--;
        }
    }
}