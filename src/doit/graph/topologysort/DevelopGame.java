package doit.graph.topologysort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//게임 개발하기 p304 backjoon 1516
//각 줄은 -1로 끝나는 경우 각 건물을 짓는 데 걸리는 시간은 100,000보다 작거나 같은 자연수라는 설명을 이해하지 못하겠다.
public class DevelopGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[N + 1]; //진입 차수 배열
        int[] selfBuild = new int[N + 1]; //자기 자신을 짓는 데 걸리는 시간
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken()); //건물을 짓는 데 걸리는 시간
            while (true) {
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1) break;
                list.get(preTemp).add(i);
                inDegree[i]++; //진입 차수 배열 초기화하기
            }
        }
        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N + 1; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list.get(now)) {
                inDegree[next]--;
                //시간 업데이트하기
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < N + 1; i++) {
            bw.write(result[i] + selfBuild[i] + "\n");
        }
        bw.close();
        br.close();
    }
}
