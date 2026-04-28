package coding.test.besuccessfulapplicants.queue.devfeat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DevelopFeatureTest {
    @Test
    void test() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] expected = {2, 1};

        var sut = new DevelopFeature();
        assertThat(sut.solution(progresses,speeds)).isEqualTo(expected);
    }
}