package coding.test.datastructure.with_java_easily.ch5;

public class Node<E> {
    public E element;
    public Node<E> next;

    public Node(E newItem) {
        element = newItem;
        next = null;
    }

    public Node(E newItem, Node<E> node) {
        element = newItem;
        next = node;
    }
}
