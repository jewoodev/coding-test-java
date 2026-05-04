package coding.test.besuccessfulapplicants.hash.receivereportresults;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void test() {
//        var id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
//        var report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        var k = 2;
//        var expected = new int[]{2,1,1,0};

        var id_list = new String[]{"con", "ryan"};
        var report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        var k = 3;
        var expected = new int[]{0,0};

        var sut = new Solution();
        assertThat(sut.solution(id_list, report, k)).isEqualTo(expected);
    }
}