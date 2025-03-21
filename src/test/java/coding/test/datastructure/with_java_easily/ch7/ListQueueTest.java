package coding.test.datastructure.with_java_easily.ch7;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ListQueueTest {
    @Test
    void test() {
        ListQueue<String> q = new ListQueue();
        q.enqueue("test 1");
        q.enqueue("test 2");
        q.enqueue("test 3");
        log.info("ListQueue dequeue: {}", q.dequeue());
    }
}