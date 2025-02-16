package coding.test.datastructure.with_java_easily.ch7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedQueueTest {
    @Test
    void test() {
        DoublyLinkedQueue q = new DoublyLinkedQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertEquals(4, q.dequeue());
        assertEquals(5, q.dequeue());
    }
}