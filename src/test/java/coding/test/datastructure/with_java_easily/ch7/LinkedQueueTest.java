package coding.test.datastructure.with_java_easily.ch7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    @Test
    void test() {
        LinkedQueue<String> q = new LinkedQueue<>();
        q.enqueue("x");
        System.out.println("Dequeue result : " + q.dequeue());
        System.out.println("Is queue empty? : " + q.isEmpty());
    }
}