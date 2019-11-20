package lesson2;
import java.lang.Object;
import java.util.Arrays;
import java.util.Comparator;

public class MyArray<T extends Comparable<T>> {

    private Object[] data;
    private int size, capacity;
    private Comparable<Object>[] arr;
    private Comparable<Object> tmp;
    private Comparable<Object> temp;

    public MyArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void add(T element){
        if(size >= capacity){
            reallocate();
        }
        data[size] = element;
        size++;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index) {
        return (T)data[index];
    }

    public int size(){
        return size;
    }

    public void add(int index, T element){
        if(size >= capacity){
            reallocate();
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data,
                    index + 1, size - index);
        }
        data[index] = element;
        size++;
    }

    private void reallocate(){
        capacity *= 2;
        Object[] tmp = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp,
                0, size);
        data = tmp;
    }

    public boolean remove(){
        size--;
        return size >= 0;
    }

    public boolean remove(int index){
        if(index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("index = " + index);
        }
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        size--;
        return true;
    }

    /*
     * Метод должен возвращать массив размером size
     * */
    public T [] toArray(){
        Object[] arr = new Object[size];
        return (T[]) arr;
    }

    /*
     * Метод должен возвращать индекс первого найденного элемента
     * или -1, если такого нет
     * */
    public int linearSearch(T element){
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i].equals(element) ) {
                return arr.length;
            }
        }
        return -1;
    }


    /*
     * Тип data - Object, но для сортировки нам нужен сравнимый тип
     * мы именного его передаем внутрь
     * Поскольку класс Объект родитель всего
     * справедлива следующая запись: ((T)arrayElement).compareTo(T otherElement)
     * Объект приведенный к типу Т, будет иметь метод сравнения
     * */
    public void insertSort(){
        int in, out;
        for(out = 1;out < this.size; out++){
            in = out;
            while(in > 0 && this.arr[in-1].compareTo(temp) > 0){
                this.arr[in] = this.arr[in-1];
                --in;
            }
            this.arr[in] = temp;
        }
    }




    static class Pair<T> {
        T element;
        Integer counter;

        public Pair(T element, Integer counter) {
            this.element = element;
            this.counter = counter;
        }
    }

    /*
     * Метод должен вернуть пару из значения элемента
     * и количества раз, которое он встретился в массиве data
     * вернуть нужно пару, элемент которой встретился наибольшее количество раз
     * А если таквых элементов много, то нужно вернуть тот, у которого значение наибольшее
     * Пусть data = [1, 3, 1, 5, 1, 4] тогда ответ new Pair<Integer>(1, 3)
     * Пусть data = [1, 2, 1, 2, 1, 2] тогда ответ new Pair<Integer>(2, 3)
     * Пусть data = [1, 2, 3, 4, 5, 6] тогда ответ new Pair<Integer>(6, 1)
     * Пусть data = [1, 1, 3, 4, 5, 6] тогда ответ new Pair<Integer>(1, 2)
     * */
    public Pair<T> taskMaxCount(){
        //TODO
        return null;
    }

    public void bubbleSort(){
        int hardCounter = 0;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                hardCounter++;
                if(arr[j].compareTo(arr[j+1]) > 0){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    /*
     * Задача под звездочкой
     * решается опционально, кому интересно
     * O(NlogN)
     * */
    public void quickSort(){
        //TODO
    }

    private void quickSort(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        /* partition */
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        /* recursion */
        if (left < j)
            quickSort(arr, left, j);
        if (i < right)
            quickSort(arr, i, right);
    }
    public static void main(String[] args) {
        MyArray<String> arr = new MyArray<>();
        for (int i = 0; i < 10; i++) {
            arr.add("i+1");
        }

        System.out.println(Arrays.toString(arr.toArray()));
    }

}