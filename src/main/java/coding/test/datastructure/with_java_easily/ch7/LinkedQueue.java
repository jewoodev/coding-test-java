package coding.test.datastructure.with_java_easily.ch7;

import coding.test.datastructure.with_java_easily.ch5.Node;

public class LinkedQueue<E> implements QueueInterface<E> { // 연습문제 2
    private Node<E> head;
    private Node<E> tail;
    private final E ERROR = null;

    public LinkedQueue() {
        head = new Node<>(null);
        tail = head;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR;
        } else {
            Node<E> front = head.next;
            head.next = front.next;
            if (front == tail)
                tail = head;
            return front.element;
        }
    }

    @Override
    public E front() {
        if (isEmpty()) return ERROR;
        else return head.next.element;
    }

    @Override
    public boolean isEmpty() {
        return (head.next == null);
    }

    @Override
    public void dequeueAll() {
        head.next = null;
        tail = head;
    }
}
