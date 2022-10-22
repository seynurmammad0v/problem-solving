package StacksNQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head = new Node<>();
    private Node<Item> tail;
    private int size = 0;

    public Deque() {
        tail = head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (isFirstItem(item)) return;
        head.prev = new Node<>(item, head, null);
        head = head.prev;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (isFirstItem(item)) return;
        tail.next = new Node<>(item, null, tail);
        tail = tail.next;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item returnValue = head.value;
        head = head.next;
        if (head != null) head.prev = null;
        else {
            head = new Node<>();
            tail = head;
        }
        size--;
        return returnValue;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item returnValue = tail.value;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else {
            tail = new Node<>();
            head = tail;
        }
        size--;
        return returnValue;
    }


    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        Node<Item> headClone;

        public QueueIterator() {
            this.headClone = head;
        }

        @Override
        public boolean hasNext() {
            return headClone != null && head.value != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = headClone.value;
            headClone = headClone.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private boolean isFirstItem(Item item) {
        if (head == tail && head.value == null) {
            head.value = item;
            size++;
            return true;
        }
        return false;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
        deque.addFirst("test");
        deque.addFirst("test2");
        deque.addLast("test3");
        deque.addLast("test4");
        deque.addLast("test5");
        deque.addLast("test6");
        deque.addFirst("test7");
        deque.addFirst("test8");
        deque.addFirst("test9");
        deque.addFirst("test10");
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println("aaa");
        deque.addFirst("test");
        deque.addFirst("test2");
        deque.addLast("test3");
        deque.addLast("test4");
        deque.addLast("test5");
        deque.addLast("test6");
        deque.addFirst("test7");
        deque.addFirst("test8");
        deque.addFirst("test9");
        deque.addFirst("test10");
        for (String s : deque) {
            System.out.println(s);
        }
        Iterator<String> iterator = deque.iterator();
        System.out.println(iterator.hasNext());
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            if (value == null) {
                throw new IllegalArgumentException();
            }
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
            this.value = null;
            this.next = null;
            this.prev = null;
        }


    }


}