package code;

public class MyArrayList<T> {
    T[] data = (T[]) new Object[10];
    int firstUnusedIndex;

    /**
     * Konstruktor, der das Objekt durch aufrufen der Clear Methode initialisiert.
     */
    public MyArrayList() {
        clear();
    }

    /**
     * Fuegt element an den Anfang der Liste ein. Wenn die Liste zu klein ist um ein weiteres Element aufzunehmen, wird resize aufgerufen um die Liste zu vergroessern.
     * @param element
     */
    public void addFirst(T element) {
        if (data.length < size() + 1) resize();
        if (size() >= 0) System.arraycopy(data, 0, data, 1, size());
        data[0] = element;
        firstUnusedIndex++;
    }

    /**
     * Fuegt element an das Ende der Liste hinzu. Wenn die Liste zu klein ist um ein weiteres Element aufzunehmen, wird resize aufgerufen um die Liste zu vergroessern.
     * @param element
     */
    public void addLast(T element) {
        if (data.length < size() + 1) resize();
        data[firstUnusedIndex++] = element;
    }

    /**
     * Gibt das Element an Position pos zurueck. Falls pos negativ ist oder pos die Groesse der Liste uebersteigt, wird eine ArrayIndexOutOfBoundsException geworfen.
     * @param pos Position des gewuenschten Elements
     * @return Element an Position pos
     * @throws ArrayIndexOutOfBoundsException
     */
    public T get(int pos) {
        if (pos < 0 || pos >= size()) throw new ArrayIndexOutOfBoundsException();
        return data[pos];
    }

    /**
     * Initialisiert data mit einem Object Array der groesse 10, welches zu einem T Array gecastet wird.
     */
    public void clear() {
        data = (T[]) new Object[10];
        firstUnusedIndex = 0;
    }

    /**
     * Gibt die Groesse der Liste zurueck.
     * @return
     */
    public int size() {
        return firstUnusedIndex;
    }


    /**
     * Initialisiert ein neues Array data2 wie bei clear schon beschrieben mit der doppelten Groesse. Danach werden die aktuellen Elemente in das neue Array kopiert und data wird mit data2 ueberschrieben.
     */
    private void resize() {
        T[] data2 = (T[]) new Object[size() * 2];
        System.arraycopy(data, 0, data2, 0, size());
        data = data2;
    }
}
