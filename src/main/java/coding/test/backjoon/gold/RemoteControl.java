package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RemoteControl { // https://www.acmicpc.net/problem/1107, 브루트 포스
    private static boolean[] broken = new boolean[10]; // 버튼이 고장나면 true

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼 갯수

        // M = 0인 경우의 수정된 처리
        if (M == 0) {
            int directPress = String.valueOf(N).length();  // 숫자 버튼으로 직접 이동
            int plusMinusOnly = Math.abs(N - 100);        // +/- 버튼으로만 이동
            System.out.println(Math.min(directPress, plusMinusOnly));
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int button = Integer.parseInt(st.nextToken());
            broken[button] = true;
        } // 고장난 버튼 저장

        int ans = Math.abs(N - 100); // +/- 버튼으로만 이동하는 경우

        // (숫자 버튼) + (+/- 버튼)으로 이동하는 경우
        // 탐색 범위를 더 넓혀서 확인
        // 0에서 +/- 눌러 500_000까지 가는 경우와 1_000_000에서 500_000까지 가는 경우 모두 가능하기 때문
        for (int i = 0; i <= 1_000_000; i++) {
            int len = possible(i); // i번 채널로 갈 수 있는지 & 자릿수
            if (len != 0) { // 갈 수 있다면
                int press = Math.abs(i - N); // i에서 N까지 +/- 버튼 횟수
                ans = Math.min(ans, len + press); // 최솟값 갱신
            }
        }
        System.out.println(ans);
    }

    /* 버튼으로 c 채널을 갈 수 있으면 길이를 return, 아니면 0을 return */
    private static int possible(int c) {
        if (c == 0) {
            if (broken[0]) return 0;
            else return 1;
        }

        int len = 0;
        for (int i = c; i > 0; i /= 10) { // 첫 번째 자릿수부터 마지막까지
            if (broken[i % 10]) return 0; // 첫 번째 자릿수가 고장났으면
            len += 1; // 아니면 다음 자릿수 탐색
        }
        return len;
    }
}