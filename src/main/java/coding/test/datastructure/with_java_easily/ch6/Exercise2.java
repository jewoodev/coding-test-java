package coding.test.datastructure.with_java_easily.ch6;

import coding.test.datastructure.with_java_easily.ch5.LinkedList;
import coding.test.datastructure.with_java_easily.ch5.ListInterface;

public class Exercise2<E> {
    private ListInterface<E> list;
    private int topIndex = 0;

    public Exercise2() {
        list = new LinkedList();
        topIndex = -1;
    }

    public void push(E newElement) {
        list.append(newElement);
        topIndex++;
    }

    public E pop() {
        E x = list.get(topIndex);
        return list.remove(topIndex--);
    }

    public E top() {
        return list.get(topIndex);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void popAll() {
        list.clear();
    }
}
