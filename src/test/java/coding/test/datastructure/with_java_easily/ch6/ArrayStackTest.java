package coding.test.datastructure.with_java_easily.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test
    void test() {
        ArrayStack<Integer> s = new ArrayStack<>(10);
        s.push(300);
        s.push(200);
        s.push(100);
        System.out.println(s.pop());
    }
}