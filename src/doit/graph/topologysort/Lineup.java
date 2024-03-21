package doit.graph.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lineup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //학생 번호의 최대값
        int m = Integer.parseInt(st.nextToken()); //키를 비교한 횟수
        List<ArrayList<Integer>> list = new ArrayList<>(); //학생 리스트
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[n + 1]; //진입 차수 배열
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            inDegree[e]++;
        }
        //위상정렬 실행
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (int next : list.get(now)) {
                if (inDegree[next] == 1) q.offer(next);
                inDegree[next]--;
            }
        }
        System.out.println(sb);
    }
}
