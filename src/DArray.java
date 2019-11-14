import java.util.Arrays;

public class DArray<T> {

    private int size, capacity;
    private Object [] data;

    public DArray() {
        size = 0;
        capacity = 10;
        data = new Object[capacity];
    }

    private void reallocate(){
        System.err.println("array was reallocated " + capacity);
        capacity *= 2;
        Object [] tmp = new Object[capacity];
        // N
        if (size >= 0) {
            System.arraycopy(data, 0,
                    tmp, 0, size);
        }
        data = tmp;
    }

    @Override
    public String toString() {
        return "DArray{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public void add(T value){
        if(size < capacity) {
            data[size] = value;
            size++;
        } else {
            reallocate();
            data[size] = value;
            size++;
        }
    }

    public void add(int index, T value){
        Object[] newArray = new Object[data.length + 1];
        for ( index = 0; index < data.length; index++) {
            newArray[index] = data[index];
        }

        newArray[newArray.length - 1] = value;
        System.out.println(Arrays.toString(newArray));
    }

    public void remove(int index){
        System.arraycopy(data, index + 1, data, index, data.length - 1 - index);
        System.out.println(Arrays.toString(data));
        System.out.println("Хахаха вот моя домашка");
    }



    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index){
        return (T) data[index];
    }
}