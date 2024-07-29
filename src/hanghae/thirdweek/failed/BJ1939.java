package hanghae.thirdweek.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BJ1939 {
    private static int start, end;
    private static List<Bridge>[] list;
    private static int[] minWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Bridge(end, weight));
            list[end].add(new Bridge(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        minWeight = new int[N + 1];
        BFS();
        System.out.println(minWeight[end]);
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Bridge bridge : list[now]) {
                if (minWeight[bridge.end] == 0) {
                    minWeight[bridge.end] = bridge.weight + minWeight[now];
                }
                else {
                    minWeight[bridge.end] = bridge.weight + minWeight[now];
                    if (bridge.end == end) return;
                }
                q.offer(bridge.end);
            }
        }
    }

    private static class Bridge {
        int end, weight;
        private Bridge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}