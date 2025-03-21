package coding.test.datastructure.with_java_easily.ch7;

import coding.test.datastructure.with_java_easily.ch5.ArrayList;
import coding.test.datastructure.with_java_easily.ch5.ListInterface;

public class ListQueue<E> implements QueueInterface<E> {
    private ListInterface<E> list;

    public ListQueue() {
        list = new ArrayList<E>();
    }

    @Override
    public void enqueue(E element) {
        list.append(element);
    }

    @Override
    public E dequeue() {
        return list.remove(0);
    }

    @Override
    public E front() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void dequeueAll() {
        list.clear();
    }
}
