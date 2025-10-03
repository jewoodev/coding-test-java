package coding.test.backjoon.gold;

//import java.io.*;
//import java.util.*;
//
//public class ABCDE { // https://www.acmicpc.net/problem/13023, DFS & 백트래킹
//    private static List<Integer>[] graph;
//    private static boolean[] visited;
//    private static boolean found;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        // 그래프 초기화
//        graph = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        // 친구 관계 입력
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            graph[a].add(b);
//            graph[b].add(a);
//        }
//
//        visited = new boolean[n];
//        found = false;
//
//        // 모든 노드에서 DFS 시작
//        for (int i = 0; i < n; i++) {
//            if (found) break;
//            dfs(i, 0);
//        }
//
//        System.out.println(found ? 1 : 0);
//    }
//
//    private static void dfs(int node, int depth) {
//        if (depth == 4) {
//            found = true;
//            return;
//        }
//
//        visited[node] = true;
//
//        for (int next : graph[node]) {
//            if (!visited[next]) {
//                dfs(next, depth + 1);
//            }
//        }
//
//        visited[node] = false;
//    }
//}


// ----------- 오답 노트 ↓ ----------- //
//import java.io.*; // 뭐 땜에 틀린 건지 파악 어려움. 문제에 대한 이해 부족.
//import java.util.*;
//
//public class ABCDE { //https://www.acmicpc.net/problem/13023, 그래프
//    private static int N;
//    private static List<Integer>[] f;
//    private static boolean[] checked;
//    private static List<Integer>[] visited;
//
//    private static void go(int start, int end) {
//        if (start == N-1) return;
//
//        for (int i = 0; i < f[start].size(); i++) {
//            if (f[start].get(i) == end) {
//                checked[start] = true;
//            }
//        }
//        go(start+1, end+1);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//
//        int[] read = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//        N = read[0];
//        checked = new boolean[N-1];
//        visited = new ArrayList[N];
//        int M = read[1];
//        f = new ArrayList[N];
//        for (int i = 0; i < N; i++) {
//            f[i] = new ArrayList<>();
//            visited[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < M; i++) {
//            read = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt).toArray();
//            f[read[0]].add(read[1]);
//        }
//
//        // 조건에 맞는 친구 관계가 있는지 검사.ㅌ
//        go(0, 1);
//
//        int ans = 1;
//        for (boolean b: checked) {
//            if (!b) {
//                ans = 0;
//                break;
//            }
//        }
//        System.out.println(ans);
//    }
//}


// ----------- 다른 풀이(인접 행렬, 간선 행렬, 인접 리스트 활용) ↓ ----------- //
import java.io.*;
import java.util.*;

public class ABCDE {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] am = new boolean[n][n]; // 인접 행렬
        List<Integer>[] em = new ArrayList[n]; // 간선 행렬
        List<Edge> al = new ArrayList<>(); // 인접 리스트

        for (int i = 0; i < n; i++) {
            em[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            al.add(new Edge(from, to));
            al.add(new Edge(to, from));
            am[from][to] = am[to][from] = true;
            em[from].add(to);
            em[to].add(from);
        }

        m *= 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                // A -> B.
                int A = al.get(i).from;
                int B = al.get(i).to;
                // C -> D.
                int C = al.get(j).from;
                int D = al.get(j).to;
                if (A == B || A == C || A == D || B == C || B == D || C == D)
                    continue;

                // B -> C.
                if (!am[B][C]) continue;

                // D -> E.
                for (int E : em[D]) {
                    if (A == E || B == E || C == E || D == E)
                        continue;

                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static class Edge {
        int from, to;
        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}