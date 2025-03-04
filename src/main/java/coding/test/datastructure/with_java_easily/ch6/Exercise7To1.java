package coding.test.datastructure.with_java_easily.ch6;

import coding.test.datastructure.with_java_easily.ch5.LinkedList;

public class Exercise7To1<E> extends LinkedList<E>
                            implements StackInterface<E> {
    public Exercise7To1() {
        super();
    }

    @Override
    public void push(E newElement) {
        add(0, newElement);
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return remove(0);
        } else return null;
    }

    @Override
    public E peek() {
        return get(0);
    }

    @Override
    public void popAll() {
        clear();
    }

    public void printAll() {
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }
}
