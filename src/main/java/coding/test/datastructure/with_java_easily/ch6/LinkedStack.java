package coding.test.datastructure.with_java_easily.ch6;

import coding.test.datastructure.with_java_easily.ch5.Node;

public class LinkedStack<E> implements StackInterface<E> {
    private Node<E> topNode;
    private final E ERROR = null;

    public LinkedStack() {
        topNode = null;
    }

    @Override
    public void push(E newElement) {
        topNode = new Node<>(newElement, topNode);
    }

    @Override
    public E pop() {
        if (isEmpty()) return ERROR;
        else {
            Node<E> temp = topNode;
            topNode = topNode.next;
            return temp.element;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) return ERROR;
        else return topNode.element;
    }

    @Override
    public boolean isEmpty() {
        return (topNode == null);
    }

    @Override
    public void popAll() {
        topNode = null;
    }
}
