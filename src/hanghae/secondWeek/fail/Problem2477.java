package hanghae.secondWeek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//Baekjoon
//이렇게 모든 면을 곱하면 안돼고 가로, 세로를 곱해야 하는데 이를 나눠서 두 개의 큐에 담아서 처리하면 될 것 같긴하다.
//복잡하게 푸는 것 같아서 다른 풀이를 확인한다.
//해보니까 그렇게 하면 어떤게 빈 사각형의 너비와 높이인지 알 수 없다. 반시계방향으로 조회가 도는 것을 이용해야 한다.
public class Problem2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer>[] pq = new PriorityQueue[5];
        for (int i = 1; i <= 4; i++) {
            pq[i] = new PriorityQueue<>((i1, i2) -> i2 - i1);
        }
        for (int i = 1; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq[a].offer(b);
        }
        int bSq = 1; //모든 면이 잘리지 않았을 때의 면적
        for (int i = 1; i <= 4; i++) {
            bSq *= pq[i].poll();
            if (i > 2) pq[i].poll();
        }
        int sSq = 1; //면적에서 뺄셈할 작은 사각형의 면적
        for (int i = 1; i <= 4; i++){
            if (!pq[i].isEmpty()) sSq *= pq[i].poll();
        }
        System.out.print((bSq - sSq) * k);
    }
}
