package coding.test.datastructure.with_java_easily.ch5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise8Test {
    @Test
    void test() {
        Exercise8.CircularDoublyLinkedList list = new Exercise8.CircularDoublyLinkedList();
        list.add(0, 300);
        list.add(0, 200);
        list.add(0, 100);
        list.append(500);
        list.append(600);
        list.remove(3);
        list.add(3, 250);
        list.add(1, 50);
        list.add(0, 10);
        list.append(700);
        list.add(650);
    }
}