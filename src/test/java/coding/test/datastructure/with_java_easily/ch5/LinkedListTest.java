package coding.test.datastructure.with_java_easily.ch5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void test() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(0, 300);
        linkedList.add(0, 200);
        linkedList.add(0, 100);
        linkedList.append(500);
        linkedList.append(600);
        linkedList.remove(3);
        linkedList.add(3, 250);
        linkedList.add(1, 50);
        linkedList.add(0, 10);
        linkedList.append(700);
        linkedList.remove(1);
        linkedList.removeItem(600);
    }
}