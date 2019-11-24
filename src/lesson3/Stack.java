package lesson3;

import java.util.Iterator;

public class Stack<T> implements LIFO<T> {

    private Node<T> tail;
    private int size;
    private Node<T> iterNode;

    public Stack() {
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T pop() {
        if (size == 0) return null;
        T top = tail.value;
        tail = tail.prev;
        size--;
        return top;
    }

    @Override
    public T top() {
        if (tail == null) return null;
        return tail.value;
    }

    @Override
    public void push(T value) {
        if (size == 0) {
            tail = new Node<>(value);
        } else {
            Node<T> node = new Node<>(value);
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void show() {
        Node<T> node = tail;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.prev;
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        iterNode = tail;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return iterNode != null;
            }

            @Override
            public T next() {
                T val = iterNode.value;
                iterNode = iterNode.prev;
                return val;
            }
        };
    }

    private class Node<T> {
        T value;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
            prev = null;
        }
    }
}