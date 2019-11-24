package lesson3;


public interface LIFO<T> extends Iterable<T>{
    int size();
    T pop();
    T top();
    void push(T value);
    void show();
}