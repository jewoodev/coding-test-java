package coding.test.datastructure.with_java_easily.ch5;

public class Node<E> {
    public E element;
    public Node<E> next;

    public Node(E element) {
        this.element = element;
        next = null;
    }

    public Node(E element, Node<E> node) {
        this.element = element;
        next = node;
    }
}
