package lesson4;

public class Node<T> {

    T value;
    Node<T> prev, next;

    public Node(T value) {
        this.value = value;
        prev = next = null;
    }
}