package code;

public class MyArrayList<T> {
    T[] data = (T[]) new Object[10];
    int firstUnusedIndex;

    public MyArrayList() {
        clear();
    }

    public void addFirst(T element) {
        if (data.length < size() + 1) resize();
        if (size() >= 0) System.arraycopy(data, 0, data, 1, size());
        data[0] = element;
        firstUnusedIndex++;
    }

    public void addLast(T element) {
        if (data.length < size() + 1) resize();
        data[firstUnusedIndex++] = element;
    }

    public T get(int pos) {
        if (pos > data.length - 1) throw new ArrayIndexOutOfBoundsException();
        return data[pos];
    }

    public void clear() {
        data = (T[]) new Object[10];
        firstUnusedIndex = 0;
    }

    public int size() {
        return firstUnusedIndex;
    }

    private void resize() {
        T[] data2 = (T[]) new Object[size() * 2];
        int index = 0;
        for (T element : data) {
            data2[index++] = element;
        }
        data = data2;
    }
}
