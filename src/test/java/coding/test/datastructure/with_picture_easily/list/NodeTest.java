package coding.test.datastructure.with_picture_easily.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class NodeTest {
    @Test
    void test() {
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        log.info(node1.data.toString());
        log.info(node1.next.data.toString());
        log.info(node1.next.next.data.toString());
    }
}