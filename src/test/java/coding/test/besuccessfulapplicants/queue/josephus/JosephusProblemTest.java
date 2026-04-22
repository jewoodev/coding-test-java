package coding.test.besuccessfulapplicants.queue.josephus;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JosephusProblemTest {
    @Test
    void test() {
        var sut = new JosephusProblem();
        assertThat(sut.solution(5, 2)).isEqualTo(3);
    }
}