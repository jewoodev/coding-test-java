package coding.test.datastructure.with_java_easily.ch7;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PalindromeTest {
    @Test
    void test() {
        log.info("Palindrome Check!");
        String str = "lioninoil";

        Palindrome p = new Palindrome();
        boolean result = p.isPalindrome(str);
        log.info("{} is Palindrome?: {}", str, result);
    }
}