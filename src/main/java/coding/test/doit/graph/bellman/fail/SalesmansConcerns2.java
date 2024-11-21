package coding.test.doit.graph.bellman.fail;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
////p344 세일즈맨의 고민 / 백준 1219
//public class SalesmansConcerns {
//    private static int n;
//    private static List<List<City>> a;
//    private static long[] earn;
//    private static long[] result;
//    private static long INF = -987654321;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken()); //도시의 개수
//        int s = Integer.parseInt(st.nextToken()); //시작 도시
//        int e = Integer.parseInt(st.nextToken()); //도착 도시
//        int m = Integer.parseInt(st.nextToken()); //교통 수단의 개수
//        result = new long[n];
//        a = new ArrayList<>(); //인접 리스트
//        for (int i = 0; i < n; i++)
//            a.add(new ArrayList<>());
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int nS = Integer.parseInt(st.nextToken());
//            int nE = Integer.parseInt(st.nextToken());
//            int nC = Integer.parseInt(st.nextToken());
//            a.get(nS).add(new City(nE, nC));
//        }
//
//        st = new StringTokenizer(br.readLine());
//        earn = new long[n]; //각 도시에서 벌 수 있는 돈
//        for (int i = 0; i < n; i++)
//            earn[i] = Long.parseLong(st.nextToken());
//
//        if (!bfs(s, e)) System.out.println("gg"); //시작 도시에서 도착 도시까지 갈 수 없는 경우
//        else if (bellmanFord(s, e)) System.out.println("Gee"); //도착 도시에 도달하는 데 무한한 돈을 버는 경우
//        else System.out.println(result[e]); //사이클 없이 도착하는 경우
//        br.close();
//    }
//
//    //특정 두 도시가 연결되어있는지 확인
//    private static boolean bfs(int startCity, int endCity) {
//        if (startCity == endCity) return true;
//
//        Queue<Integer> q = new LinkedList<>();
//        boolean[] visited = new boolean[n];
//        q.offer(startCity);
//        visited[startCity] = true;
//        while (!q.isEmpty()) {
//            int now = q.poll();
//            for (City c : a.get(now)) {
//                if (!visited[c.end]) {
//                    if (c.end == endCity) return true;
//                    visited[c.end] = true;
//                    q.offer(c.end);
//                }
//            }
//        }
//        return false;
//    }
//
//    private static boolean bellmanFord(int startCity, int endCity) {
//        Arrays.fill(result, INF);
//        result[startCity] = earn[startCity];
//        boolean update = false;
//
//        //(정점의 개수 - 1)번 동안 최단 거리 초기화 작업을 반복한다
//        int uL = n - 1; //업데이드를 확인할 횟수
//        for (int i = 0; i < uL; i++) {
//            update = false;
//            //최단거리 초기화
//            for (int j = startCity; j < n; j++) {
//                for (City city : a.get(j)) {
//                    if (result[j] == NF) break;
//                    if (result[city.end] < result[j] - city.cost + earn[city.end]) {
//                        result[city.end] = result[j] - city.cost + earn[city.end];
//                        update = true;
//                    }
//                }
//            }
//            //더 이상 최단거리 초기화가 일어나지 않으면 루프를 벗어난다
//            if (!update) break;
//        }
//        //사이클이 발생한 노드를 저장
//        List<Integer> cycleList = new ArrayList<>();
//        for (int i = startCity; i < n; i++) {
//            for (City city : a.get(i)) {
//                if (result[i] == INF) break;
//                if (result[city.end] < result[i] - city.cost + earn[city.end]) {
//                    cycleList.add(i);
//                    cycleList.add(city.end);
//                }
//            }
//        }
//
//        //사이클이 발생한 노드에서 도착 지점까지 갈 수 있는지 확인
//        for (int i = 0; i < cycleList.size(); i++) {
//            if (bfs(cycleList.get(i), endCity)) return true;
//        }
//
//        //사이클이 발생한 노드가 모두 도착 지점에 갈 수 없다면
//        //그 노드를 제외한 나머지 노드로 result를 초기화
//        Arrays.fill(result, INF);
//        result[startCity] = earn[startCity];
//        for (int i = 0; i < uL; i++) {
//            update = false;
//            for (int j = startCity; j < n; j++) {
//                for (City city : a.get(j)) {
//                    if (cycleList.contains(j) || result[j] == INF) break;
//                    if (cycleList.contains(city.end)
//                            || result[city.end] < result[j] - city.cost + earn[city.end]) {
//                        result[city.end] = result[j] - city.cost + earn[city.end];
//                        update = true;
//                    }
//                }
//            }
//            if (!update) break;
//        }
//        return false;
//    }
//}
//
//class City {
//    int end;
//    int cost;
//    City(int e, int c) {
//        end = e;
//        cost = c;
//    }
//}