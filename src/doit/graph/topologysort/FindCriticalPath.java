package doit.graph.topologysort;

//임계 경로 구하기 p309 backjoon 1948
//자료구조를 어떻게 짜야할지부터 막힌다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindCriticalPath {
    //책 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<ArrayList<dNode>> A = new ArrayList<>(); //도로 리스트
        List<ArrayList<dNode>> reverseA = new ArrayList<>();
        int[] inDegree = new int[N + 1]; //진입 차수 배열
        int[] result = new int[N + 1]; //임계 경로 배열
        for (int i = 0; i < N + 1; i++) { //1번부터 M + 2 줄까지
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int timeTaken = Integer.parseInt(st.nextToken());
            A.get(start).add(new dNode(dst, timeTaken));
            reverseA.get(dst).add(new dNode(start, timeTaken)); //역방향 엣지 정보 저장하기
            inDegree[dst]++; //진입 차수 배열 초기화하기
        }
        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int dstCity = Integer.parseInt(st.nextToken());
        queue.offer(startCity);
        while (!queue.isEmpty()) {
            int now = queue.poll(); //출발도시에서
            for (dNode next : A.get(now)) { //도로가 이어지는 도시들마다 연산
                inDegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode],
                        result[now] + next.timeTaken);
                if (inDegree[next.targetNode] == 0)
                    queue.offer(next.targetNode);
            }
        }
        //위상 정렬 reverse
        int resultCnt = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(dstCity);
        visited[dstCity] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : reverseA.get(now)) {
                //1분도 쉬지 않는 도로 체크하기
                if (result[next.targetNode] + next.timeTaken == result[now]) {
                    resultCnt++;
                    //중복 카운트 방지를 위해 이미 방문한 노드는 제외하기
                    if (!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[dstCity]);
        System.out.println(resultCnt);
    }
    static class dNode {
        int targetNode;
        int timeTaken;

        dNode(int targetNode, int timeTaken) {
            this.targetNode = targetNode;
            this.timeTaken = timeTaken;
        }
    }
}
