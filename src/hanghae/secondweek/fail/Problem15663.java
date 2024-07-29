package hanghae.secondweek.fail;

import java.io.*;
import java.util.*;

class Problem15663 {
    private static Integer[] arr;
    private static List<Integer> list;
    private static boolean[] visited;
    private static BufferedWriter bw;
    private static Set<Integer[]> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //주어지는 수의 개수
        int m = Integer.parseInt(st.nextToken()); //수열의 길이 조건
        set = new HashSet<>();
        visited = new boolean[n];
        arr = new Integer[m];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        dfs(n, m, 0);
        bw.close();
        br.close();
    }

    private static void dfs(int n, int m, int depth) throws IOException {
        if (depth == m) {
            if (!set.contains(arr)) {
                set.add(arr);
                for (int i : arr)
                    bw.write(i + " ");
                bw.write("\n");
                return;
            }
            else return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = list.get(i);
                if (depth == m) {
                    set.add(arr);
                }
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}