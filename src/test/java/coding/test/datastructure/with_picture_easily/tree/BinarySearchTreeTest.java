package coding.test.datastructure.with_picture_easily.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class BinarySearchTreeTest {
    @Test
    void test() {
        var bst = new BinarySearchTree();
        bst.insert(18);
        bst.insert(15);
        bst.insert(10);
        bst.insert(6);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(12);
        bst.insert(11);
        bst.insert(31);
        bst.insert(27);
        bst.insert(24);
        bst.insert(20);
        bst.insert(33);
        bst.insert(35);
        bst.insert(37);
        log.info("======= Initial Tree =======");
        bst.getRoot().inOrderTraversal(bst.getRoot());

        log.info("======= Search 6 =======");
        log.info(bst.search(6).toString());

        log.info("======= Search 1 =======");
        assertThat(bst.search(1)).isNull();
        log.info("1은 트리에 없습니다.");

        log.info("======= Remove 10 =======");
        bst.remove(10);
        bst.getRoot().inOrderTraversal(bst.getRoot());
    }
}