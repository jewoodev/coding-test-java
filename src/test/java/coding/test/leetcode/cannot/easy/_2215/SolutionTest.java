package coding.test.leetcode.cannot.easy._2215;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(
                    new int[]{1,2,3}, new int[]{2,4,6}, new ArrayList<>(List.of(List.of(1,3), List.of(4,6)))
                ),
                () -> test(
                    new int[]{1,2,3,3}, new int[]{1,1,2,2}, new ArrayList<>(List.of(List.of(3), List.of()))
                )
//                () -> test(
//                        new int[]{-80,-15,-81,-28,-61,63,14,-45,-35,-10},
//                        new int[]{-1,-40,-44,41,10,-43,69,10,2},
//                        new ArrayList<>(List.of(List.of(-81,-35,-10,-28,-61,-45,-15,14,-80,63),
//                                List.of(-1,2,69,-40,41,10,-43,-44)))
//                )
        );
    }

    private void test(int[] nums1, int[] nums2, List<List<Integer>> expected) {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.findDifference(nums1, nums2);
        assertEquals(expected, actual);
    }
}