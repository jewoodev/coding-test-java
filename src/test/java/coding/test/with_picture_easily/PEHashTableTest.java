package coding.test.with_picture_easily;

import coding.test.datastructure.with_picture_easily.PEHashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class PEHashTableTest {
    @Test
    void testAll() {
        assertAll(
                () -> test()
        );
    }
    private void test() throws Exception {
        PEHashTable PEHashTable = new PEHashTable();
        PEHashTable.put(1, "이운재");
        PEHashTable.put(4, "최진철");
        PEHashTable.put(20, "홍명보");
        PEHashTable.put(6, "유상철");
        PEHashTable.put(22, "송종국");
        PEHashTable.put(21, "박지성");
        PEHashTable.put(5, "김남일");
        PEHashTable.put(10, "이영표");
        PEHashTable.put(8, "최진철");
        PEHashTable.put(9, "최진철");
        PEHashTable.put(14, "최진철");

        System.out.println("1: " + PEHashTable.get(1));
        PEHashTable.remove(1);
        System.out.println("1: " + PEHashTable.get(1));
        System.out.println("21: " + PEHashTable.get(21));
    }
}