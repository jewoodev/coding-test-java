package coding.test.datastructure.with_java_easily.ch7;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int front, tail, numItems;
    private static final int DEFAULT_SIZE = 64;
    private final E ERROR = null;

    public ArrayQueue() {
        queue = (E[]) new Object[DEFAULT_SIZE];
        front = 0;
        tail = DEFAULT_SIZE - 1;
        numItems = 0;
    }

    public ArrayQueue(int size) {
        queue = (E[]) new Object[size];
        front = 0;
        tail = size - 1;
        numItems = 0;
    }

    @Override
    public void enqueue(E element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            tail = (tail + 1) % queue.length;
            queue[tail] = element;
            numItems++;
        }
    }

    private boolean isFull() {
        return (numItems == queue.length);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return ERROR;
        } else {
            E toReturn = queue[front];
            front = (front + 1) % queue.length;
            numItems--;
            return toReturn;
        }
    }

    @Override
    public E front() {
        if (isEmpty()) return ERROR;
        else return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return (numItems == 0);
    }

    @Override
    public void dequeueAll() {
        queue = (E[]) new Object[queue.length];
        front = 0;
        tail = queue.length - 1;
        numItems = 0;
    }
}
