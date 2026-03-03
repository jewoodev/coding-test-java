package coding.test.besuccessfulapplicants.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplicationTest {
    @Test
    void test() {
        int[][][] arr1 = {
                {
                        {1, 4},
                        {3, 2},
                        {4, 1}
                },
                {
                        {2,3,2},
                        {4,2,4},
                        {3,1,4}
                }
        };
        
        int[][][] arr2 = {
                {
                        {3,3},
                        {3,3}
                },
                {
                        {5,4,3},
                        {2,4,1},
                        {3,1,1}
                }
        };

        int[][][] answer = {
            {
                    {15,15},
                    {15,15},
                    {15,15}
            },
            {
                    {22,22,11},
                    {36,28,18},
                    {29,20,14}
            }
        };
        
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        for (int i = 0; i < arr1.length; i++) {
            int[][] result = matrixMultiplication.solution(arr1[i], arr2[i]);
            assertArrayEquals(answer[i], result);
        }
    }
}