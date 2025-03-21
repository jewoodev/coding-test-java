package coding.test.datastructure.with_java_easily.ch7;

import coding.test.datastructure.with_java_easily.ch5.LinkedList;

public class InheritQueue<E> extends LinkedList<E> implements QueueInterface<E> {
    public InheritQueue() {
        super();
    }

    @Override
    public void enqueue(E element) {
        append(element);
    }

    @Override
    public E dequeue() {
        return remove(0);
    }

    @Override
    public E front() {
        return get(0);
    }

    @Override
    public void dequeueAll() {
        clear();
    }
}
