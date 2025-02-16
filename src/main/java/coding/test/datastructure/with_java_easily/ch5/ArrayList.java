package coding.test.datastructure.with_java_easily.ch5;

public class ArrayList<E> implements ListInterface<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 64;
    private final int NOT_FOUND = -12345;

    public ArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(int index, E element) {
        if (size >= elements.length || index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        else {
            for (int i = size - 1; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
            size++;
        }
    }

    @Override
    public void append(E element) {
        if (size >= elements.length)
            throw new IndexOutOfBoundsException();
        else {
            elements[size++] = element;
        }
    }

    @Override
    public E remove(int index) {
        if (isEmpty() || index < 0 || index > size - 1)
            return null;
        else {
            E tmp = elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1]; // 좌시프트
            }
            size--;
            return tmp;
        }
    }

    @Override
    public boolean removeItem(E element) {
        int k = 0;
        while (k < size && !elements[k].equals(element)) {
            k++;
        }
        if (k == size)
            return false;
        else {
            remove(k);
            return true;
        }
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= size - 1)
            return elements[index];
        else
            return null;
    }

    @Override
    public void set(int index, E element) {
        if (index >= 0 && index <= size - 1)
            elements[index] = element;
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(E element) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (elements[i].equals(element))
                return i;
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[elements.length];
        size = 0;
    }
}
