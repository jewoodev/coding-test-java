package coding.test.datastructure.with_java_easily.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    @Test
    void test() {
        LinkedStack<String> s = new LinkedStack<>();
        s.push("test 1");
        s.push("test 2");
        s.push("test 3");
        System.out.println(s.pop());
    }
}