package coding.test.doit.graph.cannot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DiscernBipartiteGraph { /* P269 문제 48, 백준 1707번. 이분 그래프 판별하기 */
    /* 문제 이해가 잘 안돼서 풀이 영상 시청 */

    static boolean[] visited;
    private static ArrayList<Integer>[] a;
    private static boolean isEven;
    private static int[] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); //노드 개수
            int en = Integer.parseInt(st.nextToken()); //엣지 개수
            a = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            check = new int[v + 1];
            isEven = true;
            for (int j = 1; j < v + 1; j++) {
                a[j] = new ArrayList<Integer>();
            }
            for (int j = 0; j < en; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                a[s].add(e);
                a[e].add(s);
            }
            for (int j = 1; j < v + 1; j++) {
                if (isEven) dfs(j);
                else break;
            }
            if (isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (Integer i : a[start]) {
            if (!visited[i]) {
                check[i] = (check[start] + 1) % 2;
                dfs(i);
            } else if (check[start] == check[i]) {
                isEven = false;
            }
        }
    }
}
