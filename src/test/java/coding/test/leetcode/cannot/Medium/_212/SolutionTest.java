package coding.test.leetcode.cannot.Medium._212;

import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    void testAll() {
        assertAll(
//                () -> test(
//                        new char[][]{
//                                {'o','a','a','n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
//                        },
//                        new String[]{"oath", "pea", "eat", "rain"},
//                        new ArrayList<>(Arrays.asList("eat", "oath"))
//                ),
//                () -> test(
//                        new char[][]{
//                                {'a','b'}, {'c', 'd'}
//                        },
//                        new String[]{"abcb"},
//                        new ArrayList<>()
//                ),
//                () -> test(
//                        new char[][]{
//                                {'a','a'}
//                        },
//                        new String[]{"aaa"},
//                        new ArrayList<>()
//                ),
                () -> test(
                        new char[][]{
                                {'a','b','c'}, {'a','e','d'}, {'a','f','g'}
                        },
                        new String[]{"eaafgdcba", "eaabcdgfa"},
                        new ArrayList<>(Arrays.asList("eaafgdcba", "eaabcdgfa"))
                )
        );
    }

    private void test(char[][] board, String[] words, List<String> output) {
        Solution solution = new Solution();
        List<String> answer = solution.findWords(board, words);
        Set<String> set1 = new HashSet<>(answer);
        Set<String> set2 = new HashSet<>(output);
        assertEquals(set2, set1);
    }
}