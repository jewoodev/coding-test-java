package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindIfPathExistsInGraphTest {
    @Test
    void test() {
        int n = 10;
        int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        int source = 5;
        int destination = 9;

        var sut = new FindIfPathExistsInGraph();
        assertThat(sut.validPath(n, edges, source, destination));
    }
}