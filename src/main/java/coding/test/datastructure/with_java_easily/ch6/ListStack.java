package coding.test.datastructure.with_java_easily.ch6;

import coding.test.datastructure.with_java_easily.ch5.LinkedList;
import coding.test.datastructure.with_java_easily.ch5.ListInterface;

public class ListStack<E> implements StackInterface<E> {
    private ListInterface<E> list;

    public ListStack() {
        list = new LinkedList<E>();
    }

    @Override
    public void push(E newElement) {
        list.add(0, newElement);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void popAll() {
        list.clear();
    }
}
