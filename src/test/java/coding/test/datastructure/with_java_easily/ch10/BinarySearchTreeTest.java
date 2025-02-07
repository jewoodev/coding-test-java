package coding.test.datastructure.with_java_easily.ch10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void test1() {
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.insert(10);
        bst1.insert(20);
        bst1.insert(5);
        bst1.insert(80);
        bst1.insert(90);
        bst1.insert(75);
        bst1.insert(30);
        bst1.insert(77);
        bst1.insert(15);
        bst1.insert(40);
        Integer del1 = 20;
        bst1.delete(del1);
        bst1.delete(20);
    }

    @Test
    void test2() {
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.insert(55);
        bst1.insert(15);
        bst1.insert(8);
        bst1.insert(3);
        bst1.insert(28);
        bst1.insert(48);
        bst1.insert(38);
        bst1.insert(33);
        bst1.insert(32);
        bst1.insert(36);
        bst1.insert(50);
        bst1.insert(60);
        bst1.insert(90);
        bst1.delete(15);
        bst1.insert(90);
    }
}