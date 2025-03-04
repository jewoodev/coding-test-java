package coding.test.datastructure.with_java_easily.ch6;

import coding.test.datastructure.with_java_easily.ch5.Node;

public class Exercise3<E> {
    private Node<E> topNode;
    private final E ERROR = null;

    public Exercise3() {
        topNode = new Node<>(null);
    }

    public void push(E newElement) {
        topNode = new Node<>(newElement, topNode);
    }

    public E pop() {
        if (isEmpty()) return ERROR;
        else {
            Node<E> temp = topNode;
            topNode = topNode.next;
            return temp.element;
        }
    }

    public E peek() {
        if (isEmpty()) return ERROR;
        else return topNode.element;
    }

    public boolean isEmpty() {
        return (topNode == null);
    }

    public void popAll() {
        topNode = null;
    }
}

