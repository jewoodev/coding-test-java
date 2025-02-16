package coding.test.datastructure.with_java_easily.ch5;

public class BidirectionalNode<E> {
    public BidirectionalNode<E> prev;
    public E element;
    public BidirectionalNode<E> next;
    public BidirectionalNode() {
        prev = next = null;
        element = null;
    }

    public BidirectionalNode(E element) {
        prev = next = null;
        this.element = element;
    }

    public BidirectionalNode(BidirectionalNode<E> prev, E element, BidirectionalNode<E> next) {
        this.prev = prev;
        this.element = element;
        this.next = next;
    }
}
