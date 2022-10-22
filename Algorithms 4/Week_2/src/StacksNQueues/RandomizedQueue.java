package StacksNQueues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;
    private Item[] queue;

    // construct an empty randomized queue

    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size == queue.length) resize(queue.length * 2);
        queue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (size <= queue.length / 4) resize(queue.length / 2);
        int index = StdRandom.uniform(size);
        Item returnValue = queue[index];
        queue[index] = queue[--size];
        queue[size] = null;
        return returnValue;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniform(size);
        return queue[index];
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private final Item[] shuffledArray;

        private int current = 0;

        public RandomizedQueueIterator() {
            shuffledArray = queue.clone();
            StdRandom.shuffle(shuffledArray, 0, size);
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return shuffledArray[current++];
        }

    }


    private void resize(int newSize) {
        Item[] copy = (Item[]) new Object[newSize];
        int l = Math.min(queue.length, newSize);
        for (int i = 0; i < l; i++) {
            copy[i] = queue[i];
        }
        queue = copy;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        System.out.println(randomizedQueue.isEmpty());
        System.out.println(randomizedQueue.size());
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        randomizedQueue.enqueue(4);
        randomizedQueue.enqueue(5);
        randomizedQueue.enqueue(6);
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.sample());
        for (Integer s : randomizedQueue) {
            System.out.println(s);
        }
        randomizedQueue.iterator();
        System.out.println(randomizedQueue.isEmpty());
        Iterator<Integer> iterator = randomizedQueue.iterator();
        System.out.println(iterator.hasNext());
    }
}