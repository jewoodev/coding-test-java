package coding.test.datastructure.with_java_easily.ch7;

public interface QueueInterface<E> {
    public void enqueue(E element);
    public E dequeue();
    public E front();
    public boolean isEmpty();
    public void dequeueAll();
}
