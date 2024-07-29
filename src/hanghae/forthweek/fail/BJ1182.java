package hanghae.forthweek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
지금 연산에서는 수열의 부분 수열에서 모든 수열의 경우를 포함하지 못하고 있다.
부분 수열의 합이 S가 된 후에 추가로 다른 숫자를 포함해서도 합이 S가 될 수 있는데, 합이 S가 되면 일단 return하기 때문이다.
다만 시간초과의 이유는 모르겠다.
*/

class BJ1182 {
    private static int N, S, cnt;
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        cnt = 0; // 부분 수열의 개수
        visited = new boolean[N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        combination(0, 0, 0);
        System.out.print(cnt);
    }

    private static void combination(int depth, int start, int sum) {
        if (depth == N) {
            if (sum == S) cnt++;
            return;
        }
        else {
            for (int i = start; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    sum += arr[i];
                    combination(depth + 1 , start + 1, sum);
                    visited[i] = false;
                }
            }
        }
    }
}
