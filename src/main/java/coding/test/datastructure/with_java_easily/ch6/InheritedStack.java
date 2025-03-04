package coding.test.datastructure.with_java_easily.ch6;

import coding.test.datastructure.with_java_easily.ch5.LinkedList;

public class InheritedStack<E> extends LinkedList<E>
                                    implements StackInterface<E> {
    public InheritedStack() {
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
}
