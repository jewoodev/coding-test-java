package coding.test.datastructure.with_java_easily.ch11;

import org.junit.jupiter.api.Test;

class AVLTreeTest {
    @Test
    void test1() {
        AVLTree avl = new AVLTree();
        System.out.println("isEmpty(): " + avl.isEmpty());
//        avl.insert(10);
//        avl.insert(20);
//        avl.insert(5);
//        avl.insert(80);
//        avl.insert(90);
//        avl.delete(80);

//        avl.insert(40);
//        avl.insert(10);
//        avl.insert(55);
//        avl.insert(7);
//        avl.insert(20);
//        avl.insert(70);
//        avl.insert(17);
//        avl.insert(30);
//        avl.insert(35);

        avl.insert(40);
        avl.insert(55);
        avl.insert(20);
        avl.insert(10);
        avl.insert(60);
        avl.insert(11);
        avl.insert(5);
        avl.delete(60);
    }
}