package thisis.realization;

import java.io.*;
import java.util.StringTokenizer;

public class UpDownLeftRight {
    static int dx[] = {0, 0, -1, 1}; // L, R, U, D
    static int dy[] = {-1, 1, 0, 0};
    static String moveTypes[] = {"L", "R", "U", "D"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 연결
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 연결

        int n = Integer.parseInt(br.readLine()); // n 입력 받기

        StringTokenizer st = new StringTokenizer(br.readLine()); // 주어지는 계획서를 공백을 기준으로 나누어 담고
        String plan[] = new String[st.countTokens()]; // 해당하는 크기의 배열을 생성

        int idx = 0;
        while (st.countTokens() != 0) {
            plan[idx] = st.nextToken(); // 계획서 값 저장
            idx += 1;
        }

        int curX = 1, curY = 1; // 현재 위치
        int x = 0, y = 0; // 이동된 결과

        // 주어진 계획서대로 이동 수행
        for (int i = 0; i < plan.length; i++) {
            String element = plan[i]; // 순서대로 계획서 값을 꺼내서
            for (int j = 0; j < moveTypes.length; j++) {
                if (element.equals(moveTypes[j])) { // 그 이동값에 맞는
                    x = curX + dx[j]; // 이동 연산
                    y = curY + dy[j];
                }

                if (x < 1 || y < 1 || x > n || y > n) continue; // 공간을 벗어나지 않으면

                curX = x; // 이동
                curY = y;
            }
        }

        bw.write(curX + " " + curY);

        br.close();
        bw.close();
    }
}
