package coding.test.datastructure.with_picture_easily;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class LinkedListTest {
    @Test
    void test() {
        var list = new LinkedList<Integer>();

        log.info("====== insertAt() 다섯 번 호출 ======");
        list.insertAt(0, 0);
        list.insertAt(1, 1);
        list.insertAt(2, 2);
        list.insertAt(3, 3);
        list.insertAt(4, 4);
        list.printAll();

        log.info("====== clear() 호출 ======");
        list.clear();
        list.printAll();

        log.info("====== insertLast() 세 번 호출 ======");
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);
        list.printAll();

        log.info("====== deleteAt(0) 호출 ======");
        list.deleteAt(1);
        list.printAll();

        log.info("====== deleteLast() 호출 ======");
        list.deleteLast();
        list.printAll();

        log.info("====== getNodeAt(5) 호출 ======");
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        Node<Integer> gotNode = list.getNodeAt(5);
        log.info(gotNode.data.toString());
    }
}