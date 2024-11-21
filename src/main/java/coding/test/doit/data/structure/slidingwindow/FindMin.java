package coding.test.doit.data.structure.slidingwindow;

import java.io.*;
import java.util.*;

public class FindMin { //슬라이딩 윈도우/P74 최솟값 찾기
    /* 책의 풀이 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //n은 주어지는 수의 갯수
        int width = Integer.parseInt(st.nextToken()); //width는 슬라이딩 윈도우의 폭
        Deque<Node> dq = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while (!dq.isEmpty() && dq.getLast().val > now) {
                dq.removeLast();
            }
            dq.addLast(new Node(now, i));
            if (dq.getFirst().idx <= i - width) { //범위에서 벗어난 값은 덱에서 제거
                dq.removeFirst();
            }
            bw.write(dq.getFirst().val + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {
        private int val;
        private int idx;

        public Node(int val, int index) {
            this.val = val;
            this.idx = index;
        }
    }
}


    /* 예시는 맞는데 제출하면 오답 */
/*
    public static void Main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //n은 주어지는 수의 갯수
        int width = Integer.parseInt(st.nextToken()); //width는 슬라이딩 윈도우의 폭
        int[] a = new int[n]; //a는 주어지는 수를 저장하는 배열
        int[] d = new int[n]; //d는 구간의 최솟값을 담는 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] ints = Arrays.copyOfRange(a, 0, 3);
        ArrayList<Integer> window =
                Arrays.stream(ints).boxed().collect(Collectors.toCollection(ArrayList::new));
        int firstMin = getMin(window);
        for (int i = 0; i < 3; i++) {
            d[i] = firstMin;
        }
        for (int i = 3; i < n; i++) {
            window.add(a[i]);
            window.remove(0);
            d[i] = getMin(window);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : d) {
            bw.write(i + " ");
        }
        bw.close();
        br.close();
    }

    private static int getMin(ArrayList<Integer> w) {
        int max = Integer.MAX_VALUE;
        for (int i : w) {
            if (i < max) max = i;
        }
        return max;
    }
}
*/
