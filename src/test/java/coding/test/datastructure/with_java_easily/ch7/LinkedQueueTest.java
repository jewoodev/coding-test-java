package coding.test.datastructure.with_java_easily.ch7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    @Test
    void test() {
        LinkedQueue<String> q = new LinkedQueue<>();
        q.enqueue("x");
        q.enqueue("y");
        q.enqueue("z");

        assertEquals("x", q.dequeue());
        assertEquals("y", q.dequeue());
        assertEquals("z", q.dequeue());
    }
}