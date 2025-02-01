package coding.test.with_picture_easily;

import coding.test.datastructure.with_picture_easily.PEHashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PEHashSetTest {
    @Test
    void testAll() {
        assertAll(
                () -> test()
        );
    }
    private void test() throws Exception {
        PEHashSet hashSet = new PEHashSet();
        System.out.println("isEmpty: " + hashSet.isEmpty());
        System.out.println("===================");

        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(123);
        hashSet.add(512);
        hashSet.printAll();
        System.out.println("isEmpty: " + hashSet.isEmpty());

        System.out.println("======= 데이터 체크 =======");
        System.out.println("isContain: " + hashSet.isContain(1));

        System.out.println("======= 데이터1 제거 =======");
        hashSet.remove(1);
        hashSet.printAll();
        System.out.println("isEmpty: " + hashSet.isEmpty());

        System.out.println("======= 데이터 체크2 =======");
        System.out.println("isContain: " + hashSet.isContain(1));

        System.out.println("======= clear =======");
        hashSet.clear();
        hashSet.printAll();
        System.out.println("isEmpty: " + hashSet.isEmpty());
    }
}