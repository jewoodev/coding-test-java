package doit.data.structure.intervalsum;

import java.io.*;
import java.util.StringTokenizer;

public class IntervalSum2Correct { //p47, 정답 정리
    /**
     * 먼저 질의의 개수가 100,000개 이므로 질의마다 합을 구하면 안 되고, 구간 합 배열을 이용해야 한다는 것을 알 수 있습니다.
     * 구간 합 배열을 2차원으로 어떻게 구성할지 고민하는 것이 이 문제의 핵심입니다.
     *
     * Pseudo code
     * N(배열 크기) M(질의 수) 저장하기
     * for(N만큼 반복하기) {
     *     for(N만큼 반복하기) {
     *         원본 배열 저장하기
     *     }
     * }
     * for(N만큼 반복하기) {
     *     for(N만큼 반복하기) {
     *         합 배열 저장하기
     *     }
     * }
     * for(M만큼 반복하기) {
     *     질의에 대한 답 출력하기
     * }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //주어지는 표 크기
        int m = Integer.parseInt(st.nextToken()); //주어지는 질의 갯수

        int[][] org = new int[n+1][m+1]; //구간 합을 이용하기 위한 표 생성
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                org[i][j] = Integer.parseInt(st.nextToken()); //주어지는 배열 값 저장
            }
        }

        int[][] isa = new int[n+1][m+1]; //구간 합 배열
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) { //구간 합 드가자
                isa[i][j] = isa[i][j-1] + isa[i-1][j] - isa[i-1][j-1] + isa[i][j];
            }
        }

        for (int i = 0; i < m; i++) { //질의 응답 해드릴게요
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = isa[x2][y2] - isa[x1-1][y2] - isa[x2][y1-1] + isa[x1-1][y1-1];
            System.out.println(result);
        }

    }
}
