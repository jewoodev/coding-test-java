package coding.test.datastructure.with_java_easily.ch5;

public interface ListInterface<E> {
    public void add(int index, E element);
    public void append(E element);
    public E remove(int index);
    public boolean removeItem(E element);
    public E get(int index);
    public void set(int index, E element);
    public int indexOf(E element);
    public int len();
    public boolean isEmpty();
    public void clear();
}
