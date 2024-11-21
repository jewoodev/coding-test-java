package coding.test.hanghae.thirdweek.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
# 요구사항 정리 #
일직선 상에 놓이는 탑의 정상에 레이저 송신기가 각각 놓이고, 송신기는 왼쪽으로 레이저 신호를 보낸다.
수신 측의 탑 높이가 더 높거나 같지 않으면 신호를 수신할 수 없다. 신호를 수신한 탑들의 번호를 출력하라.

# 풀이 논리 #
배열에 탑 높이값을 저장해 일직선 상의 탑을 구현하고, 왼쪽부터 수신 가능 여부를 출력해야 하므로 왼쪽부터 확인한다.
*/

class BJ2493 {

    private static int[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        // 일직선 상의 탑을 구현
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("0").append(" ");
        // 왼쪽에서부터 오른쪽으로 확인
        for (int i = 1; i < N - 1; i++) {
            DFS(i, 1);
        }
        System.out.print(sb);
    }

    private static void DFS(int idx, int p) {
        if (idx - p < 0){
            sb.append("0").append(" ");
            return;
        }
        else {
            if (arr[idx] <= arr[idx - p]) {
                sb.append(idx - p + 1).append(" ");
                return;
            }
            DFS(idx, p + 1);
        }
    }
}
