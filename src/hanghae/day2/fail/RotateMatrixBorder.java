package hanghae.day2.fail;

import java.util.Arrays;

//행렬 테두리 회전하기, 막노동으로 푸는 문제가 아닌 거 같다
public class RotateMatrixBorder {
    static int[][] arr;
    static boolean[][] rotated;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        arr = new int[rows][columns];
        rotated = new boolean[rows][columns];

        rotate(queries);
        return answer;
    }

    private static void rotate(int[][] queries) {
        for (int[] query : queries) {
            int[] point1 = Arrays.copyOfRange(query, 0, 3);
            int[] point2 = Arrays.copyOfRange(query, 3, 5);
            //방문 처리
            for (int i = point1[0]; i < point2[0]; i++)
                for (int j = point1[1]; j < point2[1]; j++)
                    rotated[i][j] = true;
            //회전
            processRotation(point1, point2);

        }
    }

    private static void processRotation(int[] point1, int[] point2) {
        //회전하는 사각형의 모서리
        int[] p1 = point1; //왼쪽 위
        int[] p2 = new int[]{point1[0], point2[1]}; //오른쪽 위
        int[] p3 = new int[]{point2[0], point1[1]}; //왼쪽 아래
        int[] p4 = point2;

        //윗면 회전


    }
}

