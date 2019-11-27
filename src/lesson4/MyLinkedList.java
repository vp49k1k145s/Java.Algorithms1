package lesson4;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head, tail, iteratorNode;
    private Iterator<T> iterator;
    private int size;
    private T[] list;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public Iterator<T> iterator() {

        iteratorNode = head;

        return new Iterator<T>() {

            public void remove() {
                //TODO
                //удаляем текущий,
                //следующий становится текущим
            }

            @Override
            public boolean hasNext() {
                return iteratorNode !=null;
            }

            @Override
            public T next() {
                if(hasNext()){
                    T value = iteratorNode.value;
                    iteratorNode = iteratorNode.next;
                    return value;
                }
                return null;
            }
        };
    }

    void sortedAdd(T element) {
        //TODO
        //вставляем с головы в ближайшее место,
        //для которого выполняется:
        //node.prev <= tmp <= node.next
    }

    public T first() {
        return head.value;
    }


    public T last() {
        return tail.value;
    }

    void add(T element) {
        if (!(equals(element))){

        }
    }

    void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(element);
        for (int i=size-1; i>index; i--) {
            list[i] = list[i-1];
        }
        list[index] = element;
    }

    void remove() {
        //TODO
    }

    int size() {
        return size;
    }

    void remove(int index) {
        //TODO
    }

    T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    void set(int index, T value) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node prev = (Node) iterator;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.value = value;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", iteratorNode=" + iteratorNode +
                ", iterator=" + iterator +
                ", size=" + size +
                '}';
    }
}