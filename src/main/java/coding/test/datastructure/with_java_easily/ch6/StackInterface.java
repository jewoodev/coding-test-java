package coding.test.datastructure.with_java_easily.ch6;

public interface StackInterface<E> {
    public void push(E newElement);
    public E pop();
    public E peek();
    public boolean isEmpty();
    public void popAll();
}
