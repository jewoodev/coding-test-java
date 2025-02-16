package coding.test.datastructure.with_java_easily.ch7;

import coding.test.datastructure.with_java_easily.ch5.Node;

public class LinkedQueue<E> implements QueueInterface<E> {
    private Node<E> tail;
    private final E ERROR = null;

    public LinkedQueue() {
        tail = null;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR;
        } else {
            Node<E> front = tail.next;
            if (front == tail)
                tail = null;
            else
                tail.next = front.next;
            return front.element;
        }
    }

    @Override
    public E front() {
        if (isEmpty()) return ERROR;
        else return tail.next.element;
    }

    @Override
    public boolean isEmpty() {
        return (tail == null);
    }

    @Override
    public void dequeueAll() {
        tail = null;
    }
}
