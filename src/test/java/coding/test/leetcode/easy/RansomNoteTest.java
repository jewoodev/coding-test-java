package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RansomNoteTest {
    @Test
    void test() {
        String[] ransomNote = {"a", "aa", "aab"};
        String[] magazine = {"b", "ab", "aab"};
        boolean[] output = {false, false, true};
        
        var sut = new RansomNote();
        for (int i = 0; i < output.length; i++) {
            assertThat(sut.canConstruct(ransomNote[i], magazine[i])).isEqualTo(output[i]);
        }
    }
}